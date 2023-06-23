import java.io.*;
import java.net.Socket;
import java.util.Scanner;

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
                        System.out.println("12. Get the present working directory");

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
                            System.out.print("Enter the name of the file to download: ");
                            String fileName = scanner.next();
                            dos.writeUTF(fileName);

                            boolean fileExists = dis.readBoolean();

                            if (fileExists) {
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
                                System.out.println("File not found on the server.");
                            }
                        } else if (choice == 3) {
                            System.out.print("Enter the name of the directory to receive: ");
                            String directoryName = scanner.next();
                            dos.writeUTF(directoryName);

                            boolean directoryExists = dis.readBoolean();

                            if (directoryExists) {
                                int numFiles = dis.readInt();

                                for (int i = 0; i < numFiles; i++) {
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

                                System.out.println("Directory received: " + directoryName);
                            } else {
                                System.out.println("Directory not found on the server.");
                            }
                        } else if (choice == 4) {
                            System.out.print("Enter the path of the directory to send: ");
                            String directoryPath = scanner.next();
                            File directory = new File(directoryPath);

                            if (directory.exists() && directory.isDirectory()) {
                                dos.writeUTF(directory.getName());

                                File[] files = directory.listFiles();

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

                                System.out.println("Directory sent: " + directory.getName());
                            } else {
                                System.out.println("Directory not found: " + directoryPath);
                            }
                        } else if (choice == 5) {
                            System.out.print("Enter directory name: ");
                            String directoryName = scanner.nextLine();
                            dos.writeInt(choice);
                            dos.writeUTF(directoryName);

                            boolean created = dis.readBoolean();
                            if (created) {
                                System.out.println("Directory created: " + directoryName);
                            } else {
                                System.out.println("Failed to create directory: " + directoryName);
                            }
                            System.out.print("Enter directory path: ");
                            String directoryPath = scanner.nextLine();
                            dos.writeInt(choice);
                            dos.writeUTF(directoryPath);

                            int numFiles = dis.readInt();
                            int numFolders = dis.readInt();

                            if (numFiles > 0 || numFolders > 0) {
                                System.out.println("Files:");
                                for (int i = 0; i < numFiles; i++) {
                                    String fileName = dis.readUTF();
                                    System.out.println(fileName);
                                }

                                System.out.println("Folders:");
                                for (int i = 0; i < numFolders; i++) {
                                    String folderName = dis.readUTF();
                                    System.out.println(folderName);
                                }
                            } else {
                                System.out.println("No files or folders found in the directory.");
                            }
                        } else if (choice == 6) {
                            System.out.print("Enter directory path: ");
                            String directoryPath = scanner.nextLine();
                            dos.writeInt(choice);
                            dos.writeUTF(directoryPath);

                            int numFiles = dis.readInt();
                            int numFolders = dis.readInt();

                            if (numFiles > 0 || numFolders > 0) {
                                System.out.println("Files:");
                                for (int i = 0; i < numFiles; i++) {
                                    String fileName = dis.readUTF();
                                    System.out.println(fileName);
                                }

                                System.out.println("Folders:");
                                for (int i = 0; i < numFolders; i++) {
                                    String folderName = dis.readUTF();
                                    System.out.println(folderName);
                                }
                            } else {
                                System.out.println("No files or folders found in the directory.");
                            }
                        } else if (choice == 7) {
                            System.out.print("Enter source file path: ");
                            String sourceFilePath = scanner.nextLine();
                            System.out.print("Enter destination file path: ");
                            String destinationFilePath = scanner.nextLine();
                            dos.writeInt(choice);
                            dos.writeUTF(sourceFilePath);
                            dos.writeUTF(destinationFilePath);

                            System.out.println("Copying file...");
                            boolean isFileCopied = dis.readBoolean();
                            if (isFileCopied) {
                                System.out.println("File copied successfully.");
                            } else {
                                System.out.println("Failed to copy file.");
                            }
                        } else if (choice == 8) {
                            System.out.print("Enter source directory path: ");
                            String sourceDirectoryPath = scanner.next();
                            System.out.print("Enter destination directory path: ");
                            String destinationDirectoryPath = scanner.next();
                            dos.writeInt(choice);
                            dos.writeUTF(sourceDirectoryPath);
                            dos.writeUTF(destinationDirectoryPath);

                            System.out.println("Copying directory...");
                            boolean isDirectoryCopied = dis.readBoolean();
                            if (isDirectoryCopied) {
                                System.out.println("Directory copied successfully.");
                            } else {
                                System.out.println("Failed to copy directory.");
                            }
                        } else if (choice == 9) {
                            System.out.print("Enter the name of the file to delete: ");
                            String fileName = scanner.next();
                            dos.writeInt(choice);
                            dos.writeUTF(fileName);

                            System.out.println("Deleting file...");
                            boolean isFileDeleted = dis.readBoolean();
                            if (isFileDeleted) {
                                System.out.println("File deleted successfully.");
                            } else {
                                System.out.println("Failed to delete file.");
                            }
                        } else if (choice == 10) {
                            System.out.print("Enter the name of the directory to delete: ");
                            String directoryName = scanner.next();
                            dos.writeInt(choice);
                            dos.writeUTF(directoryName);

                            boolean deleted = dis.readBoolean();
                            if (deleted) {
                                System.out.println("Directory deleted: " + directoryName);
                            } else {
                                System.out.println("Failed to delete directory: " + directoryName);
                            }
                        } else if (choice == 11) {
                            System.out.print("Enter the name of the file to show content: ");
                            String fileName = scanner.next();
                            dos.writeInt(choice);
                            dos.writeUTF(fileName);

                            boolean fileExists = dis.readBoolean();

                            if (fileExists) {
                                System.out.println("File content:");

                                String line;
                                while ((line = dis.readUTF()) != null) {
                                    System.out.println(line);
                                }

                                System.out.println("End of file content.");
                            } else {
                                System.out.println("File not found: " + fileName);
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
}
