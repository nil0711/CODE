import java.io.*;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class Client {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 23456);

            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            try (
                    Scanner scanner = new Scanner(System.in)) {
                System.out.print("Enter the password: ");
                String password = scanner.nextLine();

                dos.writeUTF(password);

                boolean isAuthenticated = dis.readBoolean();

                if (isAuthenticated) {
                    System.out.println("Authentication successful!");

                    while (true) {
                        System.out.println("Choose an option:");
                        System.out.println("1. Send a file to the server");
                        System.out.println("2. Download a file from the server");
                        System.out.println("3. Send a directory to server");
                        System.out.println("4. Download a directory from server");
                        System.out.println("5. Create a directory in server");
                        System.out.println("6. Show content of the folder");
                        System.out.println("7. Copy a file in Server");
                        System.out.println("8. Copy a directory in Server");
                        System.out.println("9. Delete a File in Server");
                        System.out.println("10. Delete a directory in Server");
                        System.out.println("11. Show content of a file");

                        System.out.println();
                        System.out.print("Enter your choice: ");
                        int choice = scanner.nextInt();

                        dos.writeInt(choice);

                        if (choice == 1) {

                            System.out.print("Enter the path of the file to send: ");
                            String filePath = scanner.next();
                            File file = new File(filePath);

                            if (file.exists()) {
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
                                System.out.println("File not found: " + filePath);
                            }
                        } else if (choice == 2) {
                            System.out.print("Enter the path of the file to download: ");
                            String filePath = scanner.next();
                            dos.writeUTF(filePath);
                            dos.flush();
                            boolean fileExists = dis.readBoolean();

                            if (fileExists) {
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
                                System.out.println("File downloaded: " + fileName);
                            } else {
                                System.out.println("File doesn't exist on the server.");
                            }
                        } else if (choice == 3) {
                            System.out.print("Enter the path of the directory to send: ");
                            String directoryPath = scanner.next();
                            File directory = new File(directoryPath);

                            if (directory.exists() && directory.isDirectory()) {
                                String zipFileName = directory.getName() + ".zip";
                                zipDirectory(directory, zipFileName);

                                dos.writeUTF(zipFileName);
                                dos.writeLong(new File(zipFileName).length());

                                FileInputStream fis = new FileInputStream(zipFileName);

                                byte[] buffer = new byte[4096];
                                int bytesRead;

                                while ((bytesRead = fis.read(buffer)) != -1) {
                                    dos.write(buffer, 0, bytesRead);
                                }

                                fis.close();
                                System.out.println("Directory sent: " + directory.getName());
                            } else {
                                System.out.println("Directory not found: " + directoryPath);
                            }
                        } else if (choice == 4) {
                            System.out.print("Enter the directory path on the server: ");
                            String directoryPath = scanner.next();
                            sendDirectoryRequest(dos, dis, directoryPath);
                        } else if (choice == 5) {
                            System.out.print("Enter the name of the directory to create: ");
                            String directoryName = scanner.next();
                            dos.writeUTF(directoryName);
                            dos.flush();

                            boolean isCreated = dis.readBoolean();
                            if (isCreated) {
                                System.out.println("Directory created: " + directoryName);
                            } else {
                                System.out.println("Failed to create directory: " + directoryName);
                            }
                        } else if (choice == 6) {
                            System.out.print("Enter the target directory (or 'root' for server's directory): ");
                            String targetDirectory = scanner.next();
                            dos.writeUTF(targetDirectory);
                            dos.flush();

                            System.out.println("Listing files and folders...");
                            String fileName;
                            boolean isDirectory;

                            while (!(fileName = dis.readUTF()).isEmpty()) {
                                isDirectory = dis.readBoolean();
                                System.out.println(fileName + (isDirectory ? " (folder)" : " (file)"));
                            }
                            System.out.println("Listing complete.");
                        } else if (choice == 7) {
                            scanner.nextLine();

                            System.out.print("Enter the source file path: ");
                            String sourceFilePath = scanner.nextLine();
                            dos.writeUTF(sourceFilePath);

                            System.out.print("Enter the destination file path: ");
                            String destinationFilePath = scanner.nextLine();
                            dos.writeUTF(destinationFilePath);

                            boolean isSuccessful = dis.readBoolean();
                            if (isSuccessful) {
                                System.out.println("File copied successfully.");
                            } else {
                                System.out.println("Failed to copy the file.");
                            }
                        } else if (choice == 8) {
                            scanner.nextLine();
                            System.out.print("Enter the source directory: ");
                            String sourceDirectory = scanner.nextLine();
                            dos.writeUTF(sourceDirectory);

                            System.out.print("Enter the destination directory: ");
                            String destinationDirectory = scanner.nextLine();
                            dos.writeUTF(destinationDirectory);

                            String copyResult = dis.readUTF();
                            System.out.println(copyResult);
                        } else if (choice == 9) {
                            System.out.print("Enter the file path to delete: ");
                            scanner.nextLine();
                            String filePath = scanner.nextLine();

                            dos.writeUTF(filePath);
                            dos.flush();

                            boolean deleteStatus = dis.readBoolean();
                            if (deleteStatus) {
                                System.out.println("File successfully deleted.");
                            } else {
                                System.out.println("File does not exist or cannot be deleted.");
                            }
                        } else if (choice == 10) {
                            System.out.print("Enter the target directory: ");
                            scanner.nextLine();
                            String targetDirectory = scanner.nextLine();
                            dos.writeUTF(targetDirectory);
                            dos.flush();

                            String response = dis.readUTF();
                            System.out.println(response);
                        } else if (choice == 11) {
                            scanner.nextLine();

                            System.out.print("Enter the target file: ");
                            String targetFile = scanner.nextLine();
                            dos.writeUTF(targetFile);
                            dos.flush();

                            String fileType = dis.readUTF();
                            if (fileType.equals("text")) {
                                String line;
                                while (!(line = dis.readUTF()).equals("EOF")) {
                                    System.out.println(line);
                                }
                            } else if (fileType.equals("music")) {
                                System.out.println("The target file is an audio file.");
                            } else if (fileType.equals("video")) {
                                System.out.println("The target file is a video file.");
                            } else if (fileType.equals("unknown")) {
                                System.out.println("The target file has an unknown extension.");
                            } else if (fileType.equals("folder")) {
                                System.out.println("The target file is a folder.");
                            } else if (fileType.equals("not_found")) {
                                System.out.println("The target file was not found.");
                            } else {
                                System.out.println("Invalid response from server.");
                            }
                        } else if (choice == 12) {
                            String workingDirectory = dis.readUTF();
                            System.out.println("Present Working Directory: " + workingDirectory);
                        } else {
                            System.out.println();
                            System.out.println("Invalid choice");
                        }
                    }
                } else {
                    System.out.println("Authentication failed. Wrong password.");

                }
            }

            socket.close();
        } catch (

        IOException e) {
            e.printStackTrace();
        }
    }

    private static void zipDirectory(File directory, String zipFileName) throws IOException {
        FileOutputStream fos = new FileOutputStream(zipFileName);
        ZipOutputStream zos = new ZipOutputStream(fos);

        zip(directory, directory.getName(), zos);

        zos.close();
        fos.close();
        System.out.println("Directory zipped: " + directory.getName());
    }

    private static void zip(File fileToZip, String fileName, ZipOutputStream zos) throws IOException {
        if (fileToZip.isHidden()) {
            return;
        }

        if (fileToZip.isDirectory()) {
            if (fileName.endsWith("/")) {
                zos.putNextEntry(new ZipEntry(fileName));
                zos.closeEntry();
            } else {
                zos.putNextEntry(new ZipEntry(fileName + "/"));
                zos.closeEntry();
            }

            File[] children = fileToZip.listFiles();
            for (File childFile : children) {
                zip(childFile, fileName + "/" + childFile.getName(), zos);
            }
        } else {
            FileInputStream fis = new FileInputStream(fileToZip);
            ZipEntry zipEntry = new ZipEntry(fileName);
            zos.putNextEntry(zipEntry);

            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                zos.write(buffer, 0, bytesRead);
            }

            fis.close();
        }
    }

    private static void sendDirectoryRequest(DataOutputStream dos, DataInputStream dis, String directoryPath)
            throws IOException {
        dos.writeUTF(directoryPath);
        dos.flush();

        long fileSize = dis.readLong();
        if (fileSize == -1) {
            System.out.println("Directory not found on the server.");
            return;
        }

        String zipFileName = directoryPath + ".zip";
        File zipFile = new File(zipFileName);

        try (FileOutputStream fos = new FileOutputStream(zipFile);
                BufferedOutputStream bos = new BufferedOutputStream(fos)) {
            byte[] buffer = new byte[1024];
            int bytesRead;
            long totalBytesRead = 0;

            while (totalBytesRead < fileSize) {
                bytesRead = dis.read(buffer);
                bos.write(buffer, 0, bytesRead);
                totalBytesRead += bytesRead;
            }

            bos.flush();
        }

        unzipDirectory(zipFile, new File(directoryPath));
        try {
            zipFile.delete();
        } catch (Exception e) {
            System.out.println("Incomplete");
        }

        System.out.println("Directory downloaded successfully.");
    }

    private static void unzipDirectory(File zipFile, File outputDirectory) throws IOException {
        try (ZipInputStream zis = new ZipInputStream(new FileInputStream(zipFile))) {
            ZipEntry entry;

            while ((entry = zis.getNextEntry()) != null) {
                File entryFile = new File(outputDirectory, entry.getName());

                if (entry.isDirectory()) {
                    entryFile.mkdirs();
                } else {
                    File parent = entryFile.getParentFile();
                    if (!parent.exists()) {
                        parent.mkdirs();
                    }

                    try (FileOutputStream fos = new FileOutputStream(entryFile)) {
                        byte[] buffer = new byte[1024];
                        int bytesRead;

                        while ((bytesRead = zis.read(buffer)) != -1) {
                            fos.write(buffer, 0, bytesRead);
                        }
                    }
                }

                zis.closeEntry();
            }
        }
    }
}
