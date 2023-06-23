import java.io.*;
import java.net.*;
import java.nio.file.*;
import java.util.Comparator;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class FileServer {
    public static void main(String[] args) {
        int port = 23456;
        ServerSocket serverSocket = null;

        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Server started. Listening on port " + port);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected: " + clientSocket.getInetAddress());

                Thread clientThread = new Thread(new ClientHandler(clientSocket));
                clientThread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

class ClientHandler implements Runnable {
    private Socket clientSocket;
    private DataInputStream input;
    private DataOutputStream output;

    public ClientHandler(Socket socket) {
        this.clientSocket = socket;
    }

    public void run() {
        try {
            input = new DataInputStream(clientSocket.getInputStream());
            output = new DataOutputStream(clientSocket.getOutputStream());

            while (true) {
                output.writeUTF(
                        "Select an option:\n1. Send a file\n2.Send a directory\n3. Download a file\n4. Download a directory in zip format\n5. Create a directory\n6. List files and folders\n7. Copy a file\n8. Copy a directory\n9. Delete a file\n10. Delete a directory\n11. Play/Peek into a file\n\nEnter 'exit' to quit");

                String choice = input.readUTF();

                if (choice.equalsIgnoreCase("exit")) {
                    break;
                } else if (choice.equals("1")) {
                    sendFile();
                } else if (choice.equals("2")) {
                    sendDirectory();
                } else if (choice.equals("3")) {
                    downloadFile();
                } else if (choice.equals("4")) {
                    downloadDirectory();
                } else if (choice.equals("5")) {
                    createDirectory();
                } else if (choice.equals("6")) {
                    listContent();
                } else if (choice.equals("7")) {
                    copyFile();
                } else if (choice.equals("8")) {
                    copyDirectory();
                } else if (choice.equals("9")) {
                    deleteFile();
                } else if (choice.equals("10")) {
                    deleteDirectory();
                }else if (choice.equals("11")) {
                    showFileContent();
                }
            }
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void sendFile() throws IOException {

        output.writeUTF("Enter file: ");
        String fileName = input.readUTF();
        System.out.println("File requested to be received: " + fileName);

        long fileSize = input.readLong();

        if (fileSize != -1) {
            FileOutputStream fileOutput = new FileOutputStream(fileName);

            byte[] buffer = new byte[4096];
            int bytesRead;
            long bytesReceived = 0;

            while (bytesReceived < fileSize) {
                bytesRead = input.read(buffer);
                fileOutput.write(buffer, 0, bytesRead);
                bytesReceived += bytesRead;
            }

            fileOutput.close();

            System.out.println("File received successfully.");
            output.writeUTF("File sent successfully.");
        } else {
            System.out.println("File not found on the client side.");
            output.writeUTF("File not found.");
        }
    }

    private void downloadFile() throws IOException {
        output.writeUTF("Enter file: ");
        String fileName = input.readUTF();

        System.out.println("File requested for download: " + fileName);

        File file = new File(fileName);
        if (file.exists()) {
            output.writeLong(file.length());

            FileInputStream fileInput = new FileInputStream(file);
            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = fileInput.read(buffer)) != -1) {
                output.write(buffer, 0, bytesRead);
            }
            fileInput.close();

            System.out.println("File sent for download successfully.");
        } else {
            output.writeLong(-1);
            System.out.println("File not found for download.");
        }
    }

    private void createDirectory() throws IOException {
        output.writeUTF("Enter directory: ");
        String directoryName = input.readUTF();
        System.out.println("Directory requested to be created by client: " + directoryName);

        File directory = new File(directoryName);
        boolean created = directory.mkdir();

        if (created) {
            output.writeUTF("Directory created successfully.");
            System.out.println("Directory created successfully.");
        } else {
            output.writeUTF("Failed to create directory.");
            System.out.println("Failed to create directory.");
        }
    }

    private void listContent() throws IOException {
        String currentDirectory = System.getProperty("user.dir");
        File directory = new File(currentDirectory);
        File[] files = directory.listFiles();

        if (files != null) {
            StringBuilder content = new StringBuilder();
            for (File file : files) {
                content.append(file.getName()).append("\n");
            }
            output.writeUTF(content.toString());
        } else {
            output.writeUTF("No files or folders found.");
        }
    }

    private void copyFile() throws IOException {
        output.writeUTF("Enter file: ");
        String sourceFileName = input.readUTF();
        output.writeUTF("Enter destination: ");
        String destinationDirectoryName = input.readUTF();
        System.out.println("File copy requested by client: " + sourceFileName + " to " + destinationDirectoryName);

        File sourceFile = new File(sourceFileName);
        File destinationDirectory = new File(destinationDirectoryName);

        if (sourceFile.exists() && destinationDirectory.exists()) {
            String sourceFilePath = sourceFile.getAbsolutePath();
            String destinationFilePath = destinationDirectory.getAbsolutePath() + File.separator + sourceFile.getName();
            copyFile(sourceFilePath, destinationFilePath);

            output.writeUTF("File copied successfully.");
            System.out.println("File copied successfully.");
        } else {
            output.writeUTF("Source file not found.");
            System.out.println("Source file not found.");
        }
    }

    private void copyDirectory() throws IOException {
        output.writeUTF("Enter directory: ");
        String sourceDirectoryName = input.readUTF();
        output.writeUTF("Enter destination: ");
        String destinationDirectoryName = input.readUTF();

        System.out.println(
                "Directory copy requested by client: " + sourceDirectoryName + " to " + destinationDirectoryName);

        File sourceDirectory = new File(sourceDirectoryName);
        File destinationDirectory = new File(destinationDirectoryName);

        if (sourceDirectory.exists() && sourceDirectory.isDirectory()) {
            if (!destinationDirectory.exists()) {
                boolean created = destinationDirectory.mkdir();
                if (!created) {
                    output.writeUTF("Failed to create destination directory.");
                    System.out.println("Failed to create destination directory.");
                    return;
                }
            }

            File[] files = sourceDirectory.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        String sourceFilePath = file.getAbsolutePath();
                        String destinationFilePath = destinationDirectory.getAbsolutePath() + File.separator
                                + file.getName();
                        copyFile(sourceFilePath, destinationFilePath);
                    } else if (file.isDirectory()) {
                        String sourceSubdirectoryPath = file.getAbsolutePath();
                        String destinationSubdirectoryPath = destinationDirectory.getAbsolutePath() + File.separator
                                + file.getName();
                        copyDirectory(sourceSubdirectoryPath, destinationSubdirectoryPath);
                    }
                }

                output.writeUTF("Directory copied successfully.");
                System.out.println("Directory copied successfully.");
            } else {
                output.writeUTF("Source directory is empty.");
                System.out.println("Source directory is empty.");
            }
        } else {
            output.writeUTF("Source directory not found.");
            System.out.println("Source directory not found.");
        }
    }

    private void copyFile(String sourceFileName, String destinationFileName) throws IOException {
        File sourceFile = new File(sourceFileName);
        File destinationFile = new File(destinationFileName);

        if (sourceFile.exists()) {
            FileInputStream fileInput = new FileInputStream(sourceFile);
            FileOutputStream fileOutput = new FileOutputStream(destinationFile);

            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = fileInput.read(buffer)) != -1) {
                fileOutput.write(buffer, 0, bytesRead);
            }

            fileInput.close();
            fileOutput.close();

            DataOutputStream output = new DataOutputStream(System.out);
            output.writeUTF("File copied successfully.");
            System.out.println("File copied successfully.");
        } else {
            DataOutputStream output = new DataOutputStream(System.out);
            output.writeUTF("Source file not found.");
            System.out.println("Source file not found.");
        }
    }

    private void copyDirectory(String sourceDirectoryName, String destinationDirectoryName) throws IOException {
        File sourceDirectory = new File(sourceDirectoryName);
        File destinationDirectory = new File(destinationDirectoryName);

        if (sourceDirectory.exists() && sourceDirectory.isDirectory()) {
            if (!destinationDirectory.exists()) {
                boolean created = destinationDirectory.mkdir();
                if (!created) {
                    output.writeUTF("Failed to create destination directory.");
                    System.out.println("Failed to create destination directory.");
                    return;
                }
            }

            File[] files = sourceDirectory.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        String sourceFilePath = file.getAbsolutePath();
                        String destinationFilePath = destinationDirectory.getAbsolutePath() + File.separator
                                + file.getName();
                        copyFile(sourceFilePath, destinationFilePath);
                    } else if (file.isDirectory()) {
                        String sourceSubdirectoryPath = file.getAbsolutePath();
                        String destinationSubdirectoryPath = destinationDirectory.getAbsolutePath() + File.separator
                                + file.getName();
                        copyDirectory(sourceSubdirectoryPath, destinationSubdirectoryPath);
                    }
                }

                output.writeUTF("Directory copied successfully.");
                System.out.println("Directory copied successfully.");
            } else {
                output.writeUTF("Source directory is empty.");
                System.out.println("Source directory is empty.");
            }
        } else {
            output.writeUTF("Source directory not found.");
            System.out.println("Source directory not found.");
        }
    }

    private void deleteFile() throws IOException {
        output.writeUTF("Enter file: ");
        String fileName = input.readUTF();
        System.out.println("File deletion requested by client: " + fileName);

        Path filePath = Paths.get(fileName);
        if (Files.exists(filePath)) {
            try {
                Files.delete(filePath);
                output.writeUTF("File deleted successfully.");
                System.out.println("File deleted successfully.");
            } catch (IOException e) {
                output.writeUTF("Failed to delete file: " + e.getMessage());
                System.out.println("Failed to delete file: " + e.getMessage());
            }
        } else {
            output.writeUTF("File not found.");
            System.out.println("File not found.");
        }
    }

    private void deleteDirectory() throws IOException {
        output.writeUTF("Enter directory: ");
        String directoryName = input.readUTF();
        System.out.println("Directory deletion requested by client: " + directoryName);

        Path directoryPath = Paths.get(directoryName);
        if (Files.exists(directoryPath)) {
            try {
                Files.walk(directoryPath)
                        .sorted(Comparator.reverseOrder())
                        .map(Path::toFile)
                        .forEach(File::delete);

                output.writeUTF("Directory deleted successfully.");
                System.out.println("Directory deleted successfully.");
            } catch (IOException e) {
                output.writeUTF("Failed to delete directory: " + e.getMessage());
                System.out.println("Failed to delete directory: " + e.getMessage());
            }
        } else {
            output.writeUTF("Directory not found.");
            System.out.println("Directory not found.");
        }
    }

    private void showFileContent() throws IOException {
        String fileName = input.readUTF();
        System.out.println("File content requested by client: " + fileName);

        Path filePath = Paths.get(fileName);
        if (Files.exists(filePath)) {
            byte[] fileContent = Files.readAllBytes(filePath);
            String fileExtension = getFileExtension(fileName);

            if (isAudioFile(fileExtension)) {
                output.writeUTF("audio");
                output.writeInt(fileContent.length);
                output.write(fileContent);
            } else if (isVideoFile(fileExtension)) {
                output.writeUTF("video");
                output.writeInt(fileContent.length);
                output.write(fileContent);
            } else {
                output.writeUTF("text");
                output.writeInt(fileContent.length);
                output.write(fileContent);
            }

            System.out.println("File content sent successfully.");
        } else {
            output.writeUTF("File not found.");
            System.out.println("File not found.");
        }
    }

    private String getFileExtension(String fileName) {
        int dotIndex = fileName.lastIndexOf(".");
        if (dotIndex >= 0 && dotIndex < fileName.length() - 1) {
            return fileName.substring(dotIndex + 1).toLowerCase();
        }
        return "";
    }

    private boolean isAudioFile(String fileExtension) {
        return fileExtension.equals("mp3") || fileExtension.equals("wav");
    }

    private boolean isVideoFile(String fileExtension) {
        return fileExtension.equals("mp4") || fileExtension.equals("avi");
    }

    private void sendDirectory() throws IOException {
        output.writeUTF("Enter directory: ");
        String directoryPath = input.readUTF();
        System.out.println("Directory received from client: " + directoryPath);

        File directory = new File(directoryPath);
        if (directory.exists() && directory.isDirectory()) {
            receiveDirectoryContents(directory);
            System.out.println("Directory contents received successfully.");
            output.writeUTF("Directory contents received successfully.");
        } else {
            System.out.println("Invalid directory path.");
            output.writeUTF("Invalid directory path.");
        }
    }

    private void receiveDirectoryContents(File directory) throws IOException {
        int fileCount = input.readInt();
        int directoryCount = input.readInt();

        for (int i = 0; i < fileCount; i++) {
            String relativePath = input.readUTF();
            int fileSize = input.readInt();

            byte[] fileContent = new byte[fileSize];
            input.readFully(fileContent);

            File file = new File(directory, relativePath);
            file.getParentFile().mkdirs();

            FileOutputStream fileOutput = new FileOutputStream(file);
            fileOutput.write(fileContent);
            fileOutput.close();

            System.out.println("File received and saved: " + relativePath);
        }

        for (int i = 0; i < directoryCount; i++) {
            String relativePath = input.readUTF();

            File subdirectory = new File(directory, relativePath);
            subdirectory.mkdirs();

            System.out.println("Subdirectory created: " + relativePath);

            receiveDirectoryContents(subdirectory);
        }
    }
    private void downloadDirectory() throws IOException {
        output.writeUTF("Enter directory: ");
        String directoryName = input.readUTF();

        System.out.println("Directory requested for download: " + directoryName);

        File directory = new File(directoryName);
        if (directory.exists() && directory.isDirectory()) {
            // Create a temporary zip file
            String zipFileName = directory.getName() + ".zip";
            FileOutputStream zipFileOutput = new FileOutputStream(zipFileName);
            ZipOutputStream zipOutput = new ZipOutputStream(zipFileOutput);

            // Compress the directory recursively
            compressDirectory(directory, "", zipOutput);

            zipOutput.close();
            zipFileOutput.close();

            // Send the zip file for download
            File zipFile = new File(zipFileName);
            output.writeLong(zipFile.length());

            FileInputStream fileInput = new FileInputStream(zipFile);
            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = fileInput.read(buffer)) != -1) {
                output.write(buffer, 0, bytesRead);
            }
            fileInput.close();

            System.out.println("Directory sent for download successfully.");
        } else {
            output.writeLong(-1);
            System.out.println("Directory not found for download.");
        }
    }

    private void compressDirectory(File directory, String parentPath, ZipOutputStream zipOutput) throws IOException {
        File[] files = directory.listFiles();
        byte[] buffer = new byte[4096];
        int bytesRead;

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    FileInputStream fileInput = new FileInputStream(file);
                    ZipEntry zipEntry = new ZipEntry(parentPath + "/" + file.getName());
                    zipOutput.putNextEntry(zipEntry);

                    while ((bytesRead = fileInput.read(buffer)) != -1) {
                        zipOutput.write(buffer, 0, bytesRead);
                    }

                    fileInput.close();
                } else if (file.isDirectory()) {
                    String subdirectoryPath = parentPath + "/" + file.getName();
                    compressDirectory(file, subdirectoryPath, zipOutput);
                }
            }
        }
    }

}
