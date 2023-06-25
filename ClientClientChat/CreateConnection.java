//package ClientClientChat;
//
//import java.util.HashMap;
//
//public class CreateConnection implements Runnable {
//    HashMap<String,Information>clientList;
//    NetworkConnection nc;
//    public CreateConnection(HashMap<String,Information> cList,NetworkConnection nConnection) {
//        clientList = cList;
//        nc = nConnection;
//    }
//
//    @Override
//    public void run() {
//       Object usrObj= nc.read();
//       String username=(String) usrObj;
//
//
//        System.out.println("User : "+username+" connected");
//
//        clientList.put(username,new Information(username,nc));
//        System.out.println("Hashmap updated "+clientList);
//        new Thread(new ReaderWriterServer(username,nc,clientList)).start();
//    }
//}
