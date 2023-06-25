import java.util.*;
abstract class Pen{
    abstract void write();
    abstract void refill();
}
class FountainPen extends Pen{
    void write(){
        System.out.println("write");
    }
    void refill(){
        System.out.println("refill");
    }
}
public class java_abstract_class_sum_1 {
    public static void main(String[] args) {
       FountainPen pen=new FountainPen();
       pen.write();
       pen.refill();

    }
}
