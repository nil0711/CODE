//package ClientClientChat;
//
//import java.io.IOException;
//import java.net.InetAddress;
//import java.net.ServerSocket;
//import java.net.Socket;
//import java.util.HashMap;
//
//public class MainServer {
//    public static void main(String[] args) throws IOException {
//        ServerSocket serverSocket = new ServerSocket(22233);
//        System.out.println("Server started...");
//        System.out.println(InetAddress.getLocalHost());
//        HashMap<String,Information> clientList = new HashMap<~>();
//
//         while (true){
//             Socket socket = serverSocket.accept();
//             NetworkConnection nc = new NetworkConnection(socket);
//             new Thread(new CreateConnection(clientList,nc)).start();
//
//         }
//
//
//    }
//}
