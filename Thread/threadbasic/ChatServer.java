package Thread.threadbasic;

import java.io.*;
import java.net.*;
import java.util.*;

public class ChatServer {

    // List of connected clients
    private ArrayList<ClientThread> clients;

    // Server socket and port number
    private ServerSocket serverSocket;
    private int port;

    // Constructor to initialize port and clients list
    public ChatServer(int port) {
        this.port = port;
        clients = new ArrayList<ClientThread>();
    }

    // Method to start the server and accept client connections
    public void start() {
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Chat Server started on port " + port);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New client connected: " + socket);

                // Create a new thread for each client
                ClientThread clientThread = new ClientThread(socket);
                clients.add(clientThread);
                clientThread.start();
            }
        } catch (IOException e) {
            System.out.println("Error starting server: " + e.getMessage());
        }
    }

    // Method to broadcast a message to all connected clients
    public synchronized void broadcast(String message) {
        System.out.println("Broadcasting message: " + message);

        // Loop through all connected clients and send the message to each one
        for (ClientThread client : clients) {
            client.sendMessage(message);
        }
    }

    // Main method to start the server
    public static void main(String[] args) {
        int port = 12345; // Change this to your desired port number
        ChatServer server = new ChatServer(port);
        server.start();
    }

    // Inner class representing a client thread
    private class ClientThread extends Thread {

        // Client socket, input and output streams, and username
        private Socket socket;
        private BufferedReader input;
        private PrintWriter output;
        private String username;

        // Constructor to initialize socket, input and output streams
        public ClientThread(Socket socket) {
            this.socket = socket;
            try {
                input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                output = new PrintWriter(socket.getOutputStream(), true);
            } catch (IOException e) {
                System.out.println("Error creating input/output streams: " + e.getMessage());
            }
        }

        // Method to send a message to the client
        public void sendMessage(String message) {
            output.println(message);
        }

        // Method to set the username of the client
        public void setUsername(String username) {
            this.username = username;
        }

        // Method to handle incoming messages from the client
        public void run() {
            try {
                // Get the username from the client and set it
                output.println("Enter your username:");
                username = input.readLine();
                System.out.println("New user joined: " + username);
                broadcast(username + " has joined the chat.");

                // Loop to handle incoming messages from the client
                while (true) {
                    String message = input.readLine();
                    if (message == null) {
                        // If the client disconnects, remove it from the list of clients
                        System.out.println("Client disconnected: " + username);
                        clients.remove(this);
                        broadcast(username + " has left the chat.");
                        break;
                    }
                    System.out.println(username + ": " + message);
                    broadcast(username + ": " + message);
                }
            } catch (IOException e) {
                System.out.println("Error handling client message: " + e.getMessage());
            }
        }
    }
}
