import java.io.*;
import java.net.*;

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

                // Create a new thread to handle the client
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
                output.writeUTF("Select an option:\n1. Send a file\n2. Download a file\nEnter 'exit' to quit");

                String choice = input.readUTF();

                if (choice.equalsIgnoreCase("exit")) {
                    break;
                } else if (choice.equals("1")) {
                    sendFile();
                } else if (choice.equals("2")) {
                    downloadFile();
                }
            }

            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void sendFile() throws IOException {
        String fileName = input.readUTF();
        System.out.println("File requested by client: " + fileName);

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

            System.out.println("File sent successfully.");
        } else {
            output.writeLong(-1);
            System.out.println("File not found.");
        }
    }

    private void downloadFile() throws IOException {
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
}
