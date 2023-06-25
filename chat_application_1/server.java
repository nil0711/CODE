package chat_application_1;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class server {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ServerSocket serverSocket = new ServerSocket(22222);
        System.out.println("Server started...");
        Scanner sc = new Scanner(System.in);
        Socket socket = serverSocket.accept();
        System.out.println("Client connected...");

       while (true){


            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());

                Object cMsg = ois.readObject();
                System.out.println("From client... " + (String) cMsg);

                System.out.println("Send message to client...");
                String sMsg = sc.nextLine();

                oos.writeObject(sMsg);
        }

    }
}
