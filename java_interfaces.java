import java.util.*;
interface Camera{
    void takeSnap();
    void recordVideo();
}
interface Wifi{
    String[] getNetwork();
    void connectToNetwork(String network);

}
class CellPhone{
    void callNumber(int phoneNumber){
        System.out.println("Calling "+ phoneNumber);
    }

}
class SmartPhone extends CellPhone implements Wifi,Camera{
    public void takeSnap(){
        System.out.println("Take Snap");
    }
    public void recordVideo(){
        System.out.println("Take Video");
    }
    public String[] getNetwork(){
        System.out.println("Getting list of networks");
        String[] networkList={"Test","Campus Conect","JKMKB"};
        return networkList;
    }
    public void connectToNetwork(String network){
        System.out.println("Conecting to "+network);
    }
}
public class java_interfaces {
    public static void main(String[] args) {
        SmartPhone ms = new SmartPhone();
        String[] ar= ms.getNetwork();
        for (String item:ar) {
            System.out.println(item);
        }

    }
}
