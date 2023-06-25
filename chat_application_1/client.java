package chat_application_1;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class client {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        System.out.println("Client started...");
        Socket socket= new Socket("127.0.0.1",22222);
        System.out.println("Client connected...");

        while (true){
        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());


            System.out.println("Send message to server...");
            Scanner sc = new Scanner(System.in);
            String msg = sc.nextLine();

            oos.writeObject(msg);

                Object fromServer = ois.readObject();
                System.out.println("From server... " + (String) fromServer);

        }
    }
}
