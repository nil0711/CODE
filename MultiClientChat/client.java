package  MultiClientChat;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class client {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        System.out.println("Client started...");
        Socket socket= new Socket("127.0.0.1",22222);
        System.out.println("Client connected...");
        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());

        while (true){



            System.out.println("Send message to server...");
            Scanner sc = new Scanner(System.in);
            String msg = sc.nextLine();
            if(msg.equalsIgnoreCase("exit")) break;

//        send to server
            oos.writeObject(msg);

//            receive from server
            Object fromServer = ois.readObject();
            System.out.println("From server... " + (String) fromServer);

        }
        socket.close();


    }
}
