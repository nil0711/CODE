import java.util.*;
abstract class Base2{
    public Base2(){
        System.out.println("Ami base 2 er constructor");
    }
   public void sayHello(){
        System.out.println("Hello");
    }
   abstract public void greet();

}
class derived3 extends Base2{
    @Override
    public void greet() {
        System.out.println("Abstract hello");
    }
}
public class java_abstract {
    public static void main(String[] args) {

    }
}
