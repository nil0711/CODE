//package ClientClientChat;
//
//import java.io.IOException;
//import java.io.Reader;
//import java.io.Writer;
//import java.net.InetSocketAddress;
//import java.net.Socket;
//import java.util.Scanner;
//
//public class ClientMain {
////    String username;
////    public Reader readerThread;
////    public NetworkConnection nc;
////
////    public ClientMain(String username) throws IOException {
////        this.username=username;
////        nc=new NetworkConnection("localhost",22233);
////        nc.write(username);
////        readerThread = new Reader(nc);
////
////    }
//
//    public static void main(String[] args) throws IOException {
//        Socket socket = new Socket();
//        try{
//            socket.connect(new InetSocketAddress("www.google.com",80));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        System.out.println("Client Started--- ");
//        System.out.println(socket.getLocalAddress().getHostAddress());
//        NetworkConnection nc = new NetworkConnection(socket.getLocalAddress().getHostAddress(),22233);
//
//
//        System.out.println("Enter your username: ");
//        Scanner in = new Scanner(System.in);
//        String username = in.next();
//        nc.write(username);
//
//
//        Thread readerThread=new Thread(new Reader(nc));
//        Thread writerThread=new Thread( new Writer(nc));
//
//        try {
//            readerThread.join();
//            writerThread.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//    }
//
//}
