import java.util.*;
class super_class{
    private int a;
    public int b;
    protected int c;
   int get_method(){
        return super_class_method1();
    }
    int get_private_value(){
        return a;
    }
    void set_private_value(int p){
        a=p;
    }
    private int super_class_method1(){
        return get_private_value();
    }
    public int super_class_method2() {
        return b;
    }
    protected int super_class_method3(){
        return  c;
    }
}
class sub_class extends super_class{
    private  int d;
    public  int e;
    protected int f;
    int get_sub_class_method(){
        return sub_class_method1();
    }
    private int sub_class_method1(){
        return get_private_value();
    }
    public int sub_class_method2(){
        return b;
    }
    protected int sub_class_method3(){
        return c;
    }
}

public class single_inheritance_generic {
    public static void main(String[] args) {
      sub_class sb=new sub_class();
      sb.set_private_value(1);
      sb.b=2;
      sb.c=3;

        System.out.println("Implementing private super class method from sub "+sb.get_method());
        System.out.println("Implementing public super class method from sub "+sb.super_class_method2());
        System.out.println("Implementing protected super class method from sub "+sb.super_class_method3());
        System.out.println("Implementing private sub class method from sub "+sb.get_sub_class_method());
        System.out.println("Implementing public sub class method from sub "+sb.sub_class_method2());
        System.out.println("Implementing protected sub class method from sub "+sb.sub_class_method3());

    }
}
