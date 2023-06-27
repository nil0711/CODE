import java.io.*;
import java.net.*;

public class ChatClient {

    // Client socket, input and output streams, and username
    private Socket socket;
    private BufferedReader input;
    private PrintWriter output;
    private String username;

    // Constructor to initialize the server address and port number
    public ChatClient(String serverAddress, int port) {
        try {
            socket = new Socket(serverAddress, port);
            input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            output = new PrintWriter(socket.getOutputStream(), true);
        } catch (IOException e) {
            System.out.println("Error connecting to server: " + e.getMessage());
        }
    }

    // Method to start the client and handle user input
    public void start() {
        // Get the username from the user and send it to the server
        System.out.print("Enter your username: ");
        username = System.console().readLine();
        output.println(username);

        // Start a new thread to handle incoming messages from the server
        new Thread(new IncomingMessageHandler()).start();

        // Loop to handle user input and send messages to the server
        while (true) {
            String message = System.console().readLine();
            output.println(message);
        }
    }

    // Inner class representing a thread to handle incoming messages from the server
    private class IncomingMessageHandler implements Runnable {

        // Method to handle incoming messages from the server
        public void run() {
            try {
                while (true) {
                    String message = input.readLine();
                    if (message == null) {
                        System.out.println("Server disconnected.");
                        break;
                    }
                    System.out.println(message);
                }
            } catch (IOException e) {
                System.out.println("Error handling incoming message: " + e.getMessage());
            }
        }
    }

    // Main method to start the client
    public static void main(String[] args) {
        String serverAddress = "localhost"; // Change this to your server address
        int port = 12345; // Change this to your server port number
        ChatClient client = new ChatClient(serverAddress, port);
        client.start();
    }
}
