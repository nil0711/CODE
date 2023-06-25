import java.util.*;
abstract class TelePhone{
    abstract void ring();
    abstract void lift();
    abstract void disconnect();
}
class SmartPhoney extends TelePhone{
    void ring(){
        System.out.println("ring");
    }
    void lift(){
        System.out.println("lift");
    }
    void disconnect(){
        System.out.println("disconnect");
    }

}
public class java_class_abstract_sum_3 {
    public static void main(String[] args) {
        SmartPhoney sp=new SmartPhoney();
        sp.ring();
        sp.lift();
        sp.disconnect();
    }

}
