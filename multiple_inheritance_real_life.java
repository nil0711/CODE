interface Camera{
    void takeSnap();
    void recordVideo();
}
interface Wifi{
    String[] getNetwork();
    void connectToNetwork(String network);

}
class SmartPhone implements Wifi,Camera{
    public void takeSnap(){
        System.out.println("Take Snap");
    }
    public void recordVideo(){
        System.out.println("Take Video");
    }
    public String[] getNetwork(){
        System.out.println("Getting list of networks");
        String[] networkList={"Test","Campus Connect","Xexes"};
        return networkList;
    }
    public void connectToNetwork(String network){
        System.out.println("Connecting to "+network);
    }
}
public class multiple_inheritance_real_life {
    public static void main(String[] args) {
        SmartPhone ms = new SmartPhone();
        String[] ar= ms.getNetwork();
        for (String item:ar) {
            System.out.println(item);
        }
        System.out.println();
        ms.connectToNetwork("Test");
    }
}
