package File_Transfer_Dest;

import java.io.*;
import java.net.*;

public class FileServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;


            serverSocket = new ServerSocket(8080); // listen on port 8080


        Socket clientSocket = null;
        System.out.println("Waiting for connection.....");


        clientSocket = serverSocket.accept(); // wait for incoming connection

        System.out.println("Connection successful");
        System.out.println("Waiting for input.....");

        InputStream in = clientSocket.getInputStream();
        OutputStream out = new FileOutputStream("File_Transfer_Dest/received_file.txt");

        byte[] bytes = new byte[1024];
        int count;

        while ((count = in.read(bytes)) > 0) {
            out.write(bytes, 0, count);
        }

        out.close();
        in.close();
        clientSocket.close();
        serverSocket.close();
    }
}
