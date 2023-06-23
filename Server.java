import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Server {
    public static void main(String[] args) {
        try {
            try (ServerSocket serverSocket = new ServerSocket(23456)) {
                System.out.println("Server is running and waiting for client connections...");

                while (true) {
                    Socket clientSocket = serverSocket.accept();
                    System.out.println("Client connected: " + clientSocket.getInetAddress().getHostAddress());

                    ClientHandler clientHandler = new ClientHandler(clientSocket);
                    clientHandler.start();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class ClientHandler extends Thread {
        private Socket clientSocket;
        private DataInputStream dis;
        private DataOutputStream dos;

        public ClientHandler(Socket socket) {
            this.clientSocket = socket;
        }

        @Override
        public void run() {
            try {
                dis = new DataInputStream(clientSocket.getInputStream());
                dos = new DataOutputStream(clientSocket.getOutputStream());

                String password = dis.readUTF();

                if (password.equals("1234")) {
                    sendAuthenticationResult(true);

                    while (true) {
                        int choice = dis.readInt();
                        if (choice == 1) {
                            receiveFile();
                        } else if (choice == 2) {
                            sendFile();
                        } else if (choice == 3) {
                            receiveDirectory();
                        } else if (choice == 4) {
                            sendDirectory();
                        } else if (choice == 5) {
                            createDirectory();
                        } else if (choice == 6) {
                            listFilesAndFolders();
                        } else if (choice == 7) {
                            copyFile();
                        } else if (choice == 8) {
                            copyDirectory();
                        } else if (choice == 9) {
                            deleteFile();
                        } else if (choice == 10) {
                            deleteDirectory();
                        } else if (choice == 11) {
                            showFileContent();
                        } else if (choice == 12) {
                            sendWorkingDirectory();
                        } else {
                            System.out.println("Invalid input from client");
                        }

                    }
                } else {
                    sendAuthenticationResult(false);

                }

                clientSocket.close();
                System.out.println("Client disconnected: " + clientSocket.getInetAddress().getHostAddress());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private void sendAuthenticationResult(boolean isAuthenticated) throws IOException {
            dos.writeBoolean(isAuthenticated);
        }

        private void receiveFile() throws IOException {
            String fileName = dis.readUTF();
            long fileSize = dis.readLong();
            FileOutputStream fos = new FileOutputStream(fileName);

            byte[] buffer = new byte[4096];
            int bytesRead;
            long bytesReceived = 0;

            while (bytesReceived < fileSize) {
                bytesRead = dis.read(buffer);
                fos.write(buffer, 0, bytesRead);
                bytesReceived += bytesRead;
            }

            fos.close();
            System.out.println("File received: " + fileName);
        }

        private void sendFile() throws IOException {
            String fileName = dis.readUTF();
            File file = new File(fileName);

            if (file.exists()) {
                dos.writeBoolean(true);
                FileInputStream fis = new FileInputStream(file);

                dos.writeLong(file.length());

                byte[] buffer = new byte[4096];
                int bytesRead;

                while ((bytesRead = fis.read(buffer)) != -1) {
                    dos.write(buffer, 0, bytesRead);
                }

                fis.close();
                System.out.println("File sent: " + fileName);
            } else {
                dos.writeBoolean(false);
                System.out.println("File not found: " + fileName);
            }
        }

        private void receiveDirectory() throws IOException {

            String directoryName = dis.readUTF();

            File directory = new File(directoryName);
            if (!directory.exists()) {
                if (directory.mkdirs()) {
                    System.out.println("Directory created: " + directoryName);
                    dos.writeBoolean(true);
                } else {
                    System.out.println("Failed to create directory: " + directoryName);
                    dos.writeBoolean(false);
                    return;
                }
            } else {
                System.out.println("Directory already exists: " + directoryName);
                dos.writeBoolean(false);
                return;
            }

            int numFiles = dis.readInt();

            for (int i = 0; i < numFiles; i++) {
                String fileName = dis.readUTF();
                long fileSize = dis.readLong();
                FileOutputStream fos = new FileOutputStream(directoryName + File.separator + fileName);

                byte[] buffer = new byte[4096];
                int bytesRead;
                long bytesReceived = 0;

                while (bytesReceived < fileSize) {
                    bytesRead = dis.read(buffer);
                    fos.write(buffer, 0, bytesRead);
                    bytesReceived += bytesRead;
                }

                fos.close();
                System.out.println("File received: " + fileName);
            }

            System.out.println("Directory received: " + directoryName);
        }

        private void sendDirectory() throws IOException {
            String directoryName = dis.readUTF();
            File directory = new File(directoryName);

            if (directory.exists() && directory.isDirectory()) {
                File[] files = directory.listFiles();

                dos.writeBoolean(true);
                dos.writeInt(files.length);

                for (File file : files) {
                    if (file.isFile()) {
                        String fileName = file.getName();
                        dos.writeUTF(fileName);
                        dos.writeLong(file.length());

                        FileInputStream fis = new FileInputStream(file);

                        byte[] buffer = new byte[4096];
                        int bytesRead;

                        while ((bytesRead = fis.read(buffer)) != -1) {
                            dos.write(buffer, 0, bytesRead);
                        }

                        fis.close();
                        System.out.println("File sent: " + fileName);
                    }
                }

                System.out.println("Directory sent: " + directoryName);
            } else {
                dos.writeBoolean(false);
                System.out.println("Directory not found: " + directoryName);
            }
        }

        private void createDirectory() throws IOException {
            String directoryName = dis.readUTF();
            File directory = new File(directoryName);

            if (!directory.exists()) {
                boolean created = directory.mkdir();
                dos.writeBoolean(created);

                if (created) {
                    System.out.println("Directory created: " + directoryName);
                } else {
                    System.out.println("Failed to create directory: " + directoryName);
                }
            } else {
                dos.writeBoolean(false);
                System.out.println("Directory already exists: " + directoryName);
            }
        }

        private void listFilesAndFolders() throws IOException {
            String directoryPath = dis.readUTF();
            File directory = new File(directoryPath);

            if (directory.exists() && directory.isDirectory()) {
                File[] files = directory.listFiles();

                List<String> fileList = new ArrayList<>();
                List<String> folderList = new ArrayList<>();

                if (files != null) {
                    for (File file : files) {
                        if (file.isFile()) {
                            fileList.add(file.getName());
                        } else if (file.isDirectory()) {
                            folderList.add(file.getName());
                        }
                    }
                }

                dos.writeInt(fileList.size());
                for (String fileName : fileList) {
                    dos.writeUTF(fileName);
                }

                dos.writeInt(folderList.size());
                for (String folderName : folderList) {
                    dos.writeUTF(folderName);
                }

                System.out.println("File and folder lists sent for directory: " + directoryPath);
            } else {
                dos.writeInt(0);
                dos.writeInt(0);
                System.out.println("Directory not found: " + directoryPath);
            }
        }

        private void copyFile() throws IOException {
            String sourceFilePath = dis.readUTF();
            String destinationFilePath = dis.readUTF();

            Path sourcePath = Path.of(sourceFilePath);
            Path destinationPath = Path.of(destinationFilePath);

            Files.copy(sourcePath, destinationPath, StandardCopyOption.REPLACE_EXISTING);

            System.out.println("File copied: " + sourceFilePath + " to " + destinationFilePath);
        }

        private void copyDirectory() throws IOException {
            String sourceDirectoryPath = dis.readUTF();
            String destinationDirectoryPath = dis.readUTF();

            Path sourcePath = Path.of(sourceDirectoryPath);
            Path destinationPath = Path.of(destinationDirectoryPath);

            Files.walk(sourcePath)
                    .forEach(source -> {
                        Path destination = destinationPath.resolve(sourcePath.relativize(source));
                        try {
                            Files.copy(source, destination, StandardCopyOption.REPLACE_EXISTING);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });

            System.out.println("Directory copied: " + sourceDirectoryPath + " to " + destinationDirectoryPath);
        }

        private void deleteFile() throws IOException {
            String fileName = dis.readUTF();

            Path filePath = Paths.get(fileName);

            if (Files.exists(filePath)) {
                Files.delete(filePath);
                System.out.println("File deleted: " + fileName);
            } else {
                System.out.println("File not found: " + fileName);
            }
        }

        private void deleteDirectory() throws IOException {
            String directoryName = dis.readUTF();

            Path directoryPath = Paths.get(directoryName);

            if (Files.exists(directoryPath) && Files.isDirectory(directoryPath)) {
                Files.walk(directoryPath)
                        .sorted(Comparator.reverseOrder())
                        .map(Path::toFile)
                        .forEach(File::delete);

                System.out.println("Directory deleted: " + directoryName);
            } else {
                System.out.println("Directory not found: " + directoryName);
            }
        }

        private void showFileContent() throws IOException {
            String fileName = dis.readUTF();
            File file = new File(fileName);

            if (file.exists()) {
                dos.writeBoolean(true);

                FileInputStream fis = new FileInputStream(file);
                BufferedReader br = new BufferedReader(new InputStreamReader(fis));
                String line;

                while ((line = br.readLine()) != null) {
                    dos.writeUTF(line);
                }

                br.close();
                System.out.println("File content sent: " + fileName);
            } else {
                dos.writeBoolean(false);
                System.out.println("File not found: " + fileName);
            }
        }

        private void sendWorkingDirectory() throws IOException {
            try {
                String workingDirectory = System.getProperty("user.dir");
                dos.writeUTF(workingDirectory);
                System.out.println("Working directory sent: " + workingDirectory);
            } catch (Exception e) {
                dos.writeUTF("Directory unaccessible");
            }
        }

    }
}
