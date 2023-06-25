package ReaderWriterThread;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ServerSocket serverSocket = new ServerSocket(22222);
        System.out.println("Server started...");

        while (true){
            Socket socket = serverSocket.accept();
            System.out.println("Client connected...");

//            new Server Thread Start...
            new ReaderWriterThread.ServerThread(socket);

        }

    }
}
class ServerThread implements Runnable{
    Scanner sc = new Scanner(System.in);
    Socket clientSocket;
    Thread t;
    ServerThread(Socket clientSocket){
        this.clientSocket=clientSocket;
        t=new Thread(this);
        t.start();
    }
    @Override
    public void run() {
        try {

            ObjectInputStream ois = new ObjectInputStream(clientSocket.getInputStream());
            ObjectOutputStream oos = new ObjectOutputStream(clientSocket.getOutputStream());
//           System.out.println("Object I/O created");


//               System.out.println("Listening from client ");

//            read from client
            while (true){

                Object cMsg = ois.readObject();

                System.out.println("From client... " + (String) cMsg);

                System.out.println("Send message to client...");
                String sMsg = sc.nextLine();

                //            send to client
                oos.writeObject(sMsg);
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

