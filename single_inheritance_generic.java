import java.util.*;
class super_class{
    private int a;
    public int b;
    protected int c;
    void set
    private void super_class_method1(){
        System.out.println("Using private method in Super class and printing private attribute"+a);
    }
    public void super_class_method2(){
        System.out.println("Using public method in Super class and printing public attribute"+b);
    }
    protected void super_class_method3(){
        System.out.println("Using protected method in Super class and printing protected attribute"+c);
    }
}
class sub_class extends super_class{
    private void sub_class_method1(){
        System.out.println("Using private method in Sub class and calling private method from super class");

    }
}

public class single_inheritance_generic {
}
