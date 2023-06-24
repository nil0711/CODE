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
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class Server {
    static String pass = "1234";

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

                if (password.equals(pass)) {
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
                            String sourceFilePath = dis.readUTF();
                            String destinationFilePath = dis.readUTF();
                            copyFile(sourceFilePath, destinationFilePath);
                            sendFileCopyStatus(true);
                        } else if (choice == 8) {
                            copyDirectory();
                            dos.writeUTF("Directory copied successfully.");
                            dos.flush();
                        } else if (choice == 9) {
                            deleteFile();
                        } else if (choice == 10) {
                            deleteDirectory();
                            dos.writeUTF("Directory copied successfully.");
                            dos.flush();
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
            dos.flush();
        }

        private void createDirectory() throws IOException {
            String directoryName = dis.readUTF();
            File directory = new File(directoryName);
            boolean isCreated = directory.mkdir();

            dos.writeBoolean(isCreated);
            dos.flush();

            if (isCreated) {
                System.out.println("Directory created: " + directoryName);
            } else {
                System.out.println("Failed to create directory: " + directoryName);
            }
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
            String filePath = dis.readUTF();
            File file = new File(filePath);

            if (file.exists()) {
                dos.writeBoolean(true); 
                dos.writeUTF(file.getName());
                dos.writeLong(file.length());

                FileInputStream fis = new FileInputStream(file);
                byte[] buffer = new byte[4096];
                int bytesRead;

                while ((bytesRead = fis.read(buffer)) != -1) {
                    dos.write(buffer, 0, bytesRead);
                }

                fis.close();
                System.out.println("File sent: " + file.getName());
            } else {
                dos.writeBoolean(false); 
                System.out.println("File not found: " + filePath);
            }
        }

        private void receiveDirectory() throws IOException {
            String zipFileName = dis.readUTF();
            long fileSize = dis.readLong();

            FileOutputStream fos = new FileOutputStream(zipFileName);

            byte[] buffer = new byte[4096];
            int bytesRead;
            long bytesReceived = 0;

            while (bytesReceived < fileSize) {
                bytesRead = dis.read(buffer);
                fos.write(buffer, 0, bytesRead);
                bytesReceived += bytesRead;
            }

            fos.close();
            System.out.println("Zip file received: " + zipFileName);
            unzipFile(zipFileName);

            File zipFile = new File(zipFileName);
            if (zipFile.delete()) {
                System.out.println("Zip file deleted: " + zipFileName);

                File unzippedFolder = new File(zipFileName.substring(0, zipFileName.lastIndexOf(".")));
                File serverDirectory = new File(""); 

                if (unzippedFolder.isDirectory() && serverDirectory.isDirectory()) {
                    File[] files = unzippedFolder.listFiles();
                    if (files != null) {
                        for (File file : files) {
                            File destination = new File(serverDirectory, file.getName());
                            copyFile(file, destination);
                        }

                        deleteDirectory(unzippedFolder);
                        System.out.println("Unzipped folder deleted: " + unzippedFolder.getAbsolutePath());
                    } else {
                        System.out.println("No files found in the unzipped folder.");
                    }
                } else {
                    System.out.println("Failed to copy directory contents to the server.");
                }
            } else {
                System.out.println("Failed to delete zip file: " + zipFileName);
            }
        }

        private void unzipFile(String zipFileName) throws IOException {
            try (ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(zipFileName))) {
                byte[] buffer = new byte[4096];
                ZipEntry entry = zipInputStream.getNextEntry();

                while (entry != null) {
                    String filePath = entry.getName();

                    if (!entry.isDirectory()) {
                        File file = new File(filePath);
                        File parentDir = file.getParentFile();
                        if (!parentDir.exists()) {
                            parentDir.mkdirs();
                        }

                        FileOutputStream fos = new FileOutputStream(file);

                        int bytesRead;
                        while ((bytesRead = zipInputStream.read(buffer)) != -1) {
                            fos.write(buffer, 0, bytesRead);
                        }

                        fos.close();
                    } else {
                        File dir = new File(filePath);
                        dir.mkdirs();
                    }

                    zipInputStream.closeEntry();
                    entry = zipInputStream.getNextEntry();
                }
            }
        }

        private void copyFile(File source, File destination) throws IOException {
            try (InputStream is = new FileInputStream(source);
                    OutputStream os = new FileOutputStream(destination)) {
                byte[] buffer = new byte[4096];
                int bytesRead;

                while ((bytesRead = is.read(buffer)) != -1) {
                    os.write(buffer, 0, bytesRead);
                }
            }
        }

        private void deleteDirectory() {
            try {
                String targetDirectory = dis.readUTF();
                Path directoryPath = Paths.get(targetDirectory);

                if (Files.exists(directoryPath) && Files.isDirectory(directoryPath)) {
                    Files.walk(directoryPath)
                            .sorted(Comparator.reverseOrder())
                            .map(Path::toFile)
                            .forEach(File::delete);
                    System.out.println("Directory deleted: " + targetDirectory);

                } else {
                    System.out.println("Target directory does not exist: " + targetDirectory);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        private void deleteDirectory(File unzippedFolder) {
            try {
                String targetDirectory = unzippedFolder.getAbsolutePath();
                Path directoryPath = Paths.get(targetDirectory);

                if (Files.exists(directoryPath) && Files.isDirectory(directoryPath)) {
                    Files.walk(directoryPath)
                            .sorted(Comparator.reverseOrder())
                            .map(Path::toFile)
                            .forEach(File::delete);
                    System.out.println("Directory deleted: " + targetDirectory);

                } else {
                    System.out.println("Target directory does not exist: " + targetDirectory);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private void sendDirectory() throws IOException {
            String directoryPath = dis.readUTF();
            File directory = new File(directoryPath);

            if (directory.exists() && directory.isDirectory()) {
                String zipFileName = directory.getName() + ".zip";
                File zipFile = new File(zipFileName);

                try (ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(zipFile))) {
                    zipDirectory(directory, zos);
                }

                try (FileInputStream fis = new FileInputStream(zipFile);
                        BufferedInputStream bis = new BufferedInputStream(fis)) {

                    long fileSize = zipFile.length();
                    dos.writeLong(fileSize);
                    dos.flush();

                    byte[] buffer = new byte[1024];
                    int bytesRead;
                    while ((bytesRead = bis.read(buffer)) != -1) {
                        dos.write(buffer, 0, bytesRead);
                    }
                    dos.flush();
                }

                zipFile.delete();
            } else {
                dos.writeLong(-1);
                dos.flush();
            }
        }

        private void zipDirectory(File sourceFile, ZipOutputStream zos) throws IOException {
            if (sourceFile.isDirectory()) {
                File[] files = sourceFile.listFiles();

                if (files != null) {
                    for (File file : files) {
                        zipDirectory(file, zos);
                    }
                }
            } else {
                FileInputStream fis = new FileInputStream(sourceFile);
                String entryName = sourceFile.getPath();

                entryName = entryName.replaceFirst("^" + sourceFile.getParent(), "");

                if (entryName.startsWith(File.separator)) {
                    entryName = entryName.substring(1);
                }

                ZipEntry entry = new ZipEntry(entryName);
                zos.putNextEntry(entry);

                byte[] buffer = new byte[1024];
                int bytesRead;
                while ((bytesRead = fis.read(buffer)) != -1) {
                    zos.write(buffer, 0, bytesRead);
                }

                fis.close();
                zos.closeEntry();
            }
        }

        private void listFilesAndFolders() throws IOException {
            String targetDirectory = dis.readUTF();

            File directory;
            if (targetDirectory.equals("root")) {
                directory = new File(".");
            } else {
                directory = new File(targetDirectory);
            }

            File[] filesAndFolders = directory.listFiles();

            if (filesAndFolders != null) {
                for (File file : filesAndFolders) {
                    dos.writeUTF(file.getName());
                    dos.writeBoolean(file.isDirectory());
                }
            }

            dos.writeUTF("");
            dos.flush();
        }

        private void copyFile(String sourceFilePath, String destinationFilePath) throws IOException {
            File source = new File(sourceFilePath);
            File destination = new File(destinationFilePath);

            try (InputStream is = new FileInputStream(source);
                    OutputStream os = new FileOutputStream(destination)) {
                byte[] buffer = new byte[4096];
                int bytesRead;

                while ((bytesRead = is.read(buffer)) != -1) {
                    os.write(buffer, 0, bytesRead);
                }
            }
        }

        private void sendFileCopyStatus(boolean isSuccessful) throws IOException {
            dos.writeBoolean(isSuccessful);
            dos.flush();
        }

        private void copyDirectory() throws IOException {
            String sourceDirectory = dis.readUTF();
            String destinationDirectory = dis.readUTF();

            File sourceDir = new File(sourceDirectory);
            File destDir = new File(destinationDirectory);

            if (!sourceDir.exists()) {
                dos.writeUTF("Source directory does not exist.");
                dos.flush();
                return;
            }

            if (!destDir.exists()) {
                destDir.mkdirs();
                dos.writeUTF("Destination directory created.");
                dos.flush();
            }

            if (!sourceDir.isDirectory()) {
                dos.writeUTF("Source path is not a directory.");
                dos.flush();
                return;
            }

            File[] files = sourceDir.listFiles();

            if (files == null) {
                dos.writeUTF("Error occurred while accessing files in the source directory.");
                dos.flush();
                return;
            }

            for (File file : files) {
                Path sourcePath = file.toPath();
                Path destinationPath = Paths.get(destDir.getAbsolutePath(), file.getName());
                Files.copy(sourcePath, destinationPath, StandardCopyOption.REPLACE_EXISTING);
            }

            dos.writeUTF("Directory copied successfully.");
            dos.flush();
        }

        private void deleteFile() throws IOException {
            String targetFile = dis.readUTF();
            Path filePath = Paths.get(targetFile);

            if (Files.exists(filePath)) {
                Files.delete(filePath);

                dos.writeBoolean(true); 
            } else {
                dos.writeBoolean(false); 
            }

            dos.flush();
        }

        private void showFileContent() throws IOException {
            String targetFile = dis.readUTF();

            File file = new File(targetFile);

            if (file.exists()) {
                if (file.isFile()) {
                    String extension = getFileExtension(file);

                    if (extension.equalsIgnoreCase("txt")) {
                        dos.writeUTF("text");
                        dos.flush();

                        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                            String line;
                            while ((line = br.readLine()) != null) {
                                dos.writeUTF(line);
                                dos.flush();
                            }
                        }
                    } else if (extension.equalsIgnoreCase("mp3")) {
                        dos.writeUTF("music");
                        dos.flush();
                    } else if (extension.equalsIgnoreCase("mp4")) {
                        dos.writeUTF("video");
                        dos.flush();
                    } else {
                        dos.writeUTF("unknown");
                        dos.flush();
                    }
                } else {
                    dos.writeUTF("folder");
                    dos.flush();
                }
            } else {
                dos.writeUTF("not_found");
                dos.flush();
            }

            
            dos.writeUTF("EOF");
            dos.flush();
        }

        private String getFileExtension(File file) {
            String extension = "";
            String fileName = file.getName();
            int dotIndex = fileName.lastIndexOf('.');
            if (dotIndex > 0 && dotIndex < fileName.length() - 1) {
                extension = fileName.substring(dotIndex + 1).toLowerCase();
            }
            return extension;
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
