package File_Transfer_Source;

import java.io.*;
import java.net.*;

public class FileClient {
    public static void main(String[] args) throws IOException {
        Socket socket = null;
        String host = "localhost"; // the hostname of the server
        int port = 8080; // the port number to connect to


            socket = new Socket(host, port); // connect to the server


        System.out.println("Connection successful");
        System.out.println("Sending file.....");

        File file = new File("File_Transfer_Source/file_to_send.txt");
        FileInputStream in = new FileInputStream(file);
        OutputStream out = socket.getOutputStream();

        byte[] bytes = new byte[1024];
        int count;

        while ((count = in.read(bytes)) > 0) {
            out.write(bytes, 0, count);
        }

        out.close();
        in.close();
        socket.close();
    }
}
