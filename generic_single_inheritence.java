import  java.util.*;
class a{
    public int a;
    private int b;
    protected int c;
   void geta(){
        private_method(b);
    }
    void set(int b1){
        b=b1;
    }
    int get_value(){
       return b;
    }

    public void public_method(int a){
        System.out.println("Using public method in super class "+ a);
    }
    private void private_method(int b){
        System.out.println("Using private method in super class "+b);
    }
    protected void protected_method(int c){
        System.out.println("Using protected method in super class "+c);
    }
}
class  b extends a{
    void getb(){
        private_method_1(get_value());
    }

    public void public_method_1(int a) {
        System.out.println("Using public method from sub class"+a);
    }
    private void private_method_1(int b) {
        System.out.println("Using private method from sub class "+b);
    }
    protected void protected_method_1(int c) {
        System.out.println("Using protected method from sub class "+c);
    }

}
public class generic_single_inheritence {
    public static void main(String[] args) {
        a obj1 = new a();
        obj1.public_method(1);
        obj1.protected_method(2);
        obj1.set(3);
        obj1.geta();

        b obj2=new b();
        obj2.public_method_1(4);
        obj2.protected_method_1(5);
        obj2.set(6);
        obj2.getb();

        a obj3=new b();
        obj3.public_method(7);
        obj3.protected_method(8);
        obj3.set(9);
        obj3.geta();
    }
}
