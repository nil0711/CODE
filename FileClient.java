import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class FileClient {
    public static void main(String[] args) {
        String serverAddress = "localhost";
        int serverPort = 23456;

        try {
            Socket socket = new Socket(serverAddress, serverPort);
            System.out.println("Connected to server.");

            DataInputStream input = new DataInputStream(socket.getInputStream());
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            String serverMessage;
            String clientChoice;

            while (true) {
                serverMessage = input.readUTF();
                System.out.println(serverMessage);

                clientChoice = reader.readLine();
                output.writeUTF(clientChoice);

                if (clientChoice.equalsIgnoreCase("exit")) {
                    break;
                }
            }

            socket.close();
            System.out.println("Disconnected from server.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}