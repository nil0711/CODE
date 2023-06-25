

class super_class_hi{
    private int a;
    public int b;
    protected int c;

    void set_private_value(int p){
        b=p;
    }
    int get_private_value(){
        return b;
    }
    void get_private_super_method(){
        super_method1();
    }

    private void super_method1(){
        System.out.println("Using private method in super class and printing private variable "+get_private_value());
    }
    public void super_method2(){
        System.out.println("Using public method in super class and printing public variable "+b);
    }
    protected void super_method3(){
        System.out.println("Using protected method in super class and printing protected variable "+c);
    }
}
class sub_class_hi_1 extends super_class_hi{
    void get_sub_class_1_private_method(){
        sub_1_method_1();
    }
    private void sub_1_method_1(){
        System.out.println("Using private method in sub class 1 and calling private method from super class");
        get_private_super_method();
    }
    public void sub_1_method_2(){
        System.out.println("Using public method in sub class 1 and calling public method from super class");
        super_method2();
    }
    protected void sub_1_method_3(){
        System.out.println("Using protected method in sub class 1 and calling protected method from super class");
        super_method3();
    }
}
class sub_class_hi_2 extends super_class_hi{
    void get_sub_class_2_private_method(){
        sub_2_method_1();
    }
    private void sub_2_method_1(){
        System.out.println("Using private method in sub class 2 and calling private method from super class");
        get_private_super_method();
    }
    public void sub_2_method_2(){
        System.out.println("Using public method in sub class 2 and calling public method from super class");
        super_method2();
    }
    protected void sub_2_method_3(){
        System.out.println("Using protected method in sub class 2 and calling protected method from super class");
        super_method3();
    }
}
class sub_sub_class_hi_1 extends sub_class_hi_1{
    void get_sub_sub_class_1_private_method(){
        sub_sub_1_method_1();
    }
    private void sub_sub_1_method_1(){
        System.out.println("Using private method in sub_sub class 1 and calling private method from super class and sub class 1");
        get_private_super_method();
        get_sub_class_1_private_method();
    }
    public void sub_sub_1_method_2(){
        System.out.println("Using public method in sub_sub class 1 and calling public method from super class and sub class 1");
        super_method2();
        sub_1_method_2();
    }
    protected void sub_sub_1_method_3(){
        System.out.println("Using protected method in sub_sub class 1 and calling protected method from super class and sub class 1");
        super_method3();
        sub_1_method_3();
    }
}
class sub_sub_class_hi_2 extends sub_class_hi_1{
    void get_sub_sub_class_2_private_method(){
        sub_sub_2_method_1();
    }
    private void sub_sub_2_method_1(){
        System.out.println("Using private method in sub_sub class 2 and calling private method from super class and sub class 1");
        get_private_super_method();
        get_sub_class_1_private_method();
    }
    public void sub_sub_2_method_2(){
        System.out.println("Using public method in sub_sub class 2 and calling public method from super class and sub class 1");
        super_method2();
        sub_1_method_2();
    }
    protected void sub_sub_2_method_3(){
        System.out.println("Using protected method in sub_sub class 2 and calling protected method from super class and sub class 1");
        super_method3();
        sub_1_method_3();
    }
}
class sub_sub_class_hi_3 extends sub_class_hi_2{
    void get_sub_sub_class_3_private_method(){
        sub_sub_3_method_1();
    }
    private void sub_sub_3_method_1(){
        System.out.println("Using private method in sub_sub class 3 and calling private method from super class and sub class 2");
        get_private_super_method();
        get_sub_class_2_private_method();
    }
    public void sub_sub_3_method_2(){
        System.out.println("Using public method in sub_sub class 3 and calling public method from super class and sub class 2");
        super_method2();
        sub_2_method_2();
    }
    protected void sub_sub_3_method_3(){
        System.out.println("Using protected method in sub_sub class 3 and calling protected method from super class and sub class 2");
        super_method3();
        sub_2_method_3();
    }
}
class sub_sub_class_hi_4 extends sub_class_hi_2{
    void get_sub_sub_class_4_private_method(){
        sub_sub_4_method_1();
    }
    private void sub_sub_4_method_1(){
        System.out.println("Using private method in sub_sub class 4 and calling private method from super class and sub class 2");
        get_private_super_method();
        get_sub_class_2_private_method();
    }
    public void sub_sub_4_method_2(){
        System.out.println("Using public method in sub_sub class 4 and calling public method from super class and sub class 2");
        super_method2();
        sub_2_method_2();
    }
    protected void sub_sub_4_method_3(){
        System.out.println("Using protected method in sub_sub class 4 and calling protected method from super class and sub class 2");
        super_method3();
        sub_2_method_3();
    }
}

public class hierarchical_inheritance_generic {
    public static void main(String[] args) {
        sub_sub_class_hi_1 ss1= new sub_sub_class_hi_1();
        sub_sub_class_hi_2 ss2= new sub_sub_class_hi_2();
        sub_sub_class_hi_3 ss3= new sub_sub_class_hi_3();
        sub_sub_class_hi_4 ss4= new sub_sub_class_hi_4();

        System.out.println("Implementing object created from sub sub class 1 with reference to same class");
        ss1.set_private_value(1);
        ss1.b=2;
        ss1.c=3;

        ss1.get_private_super_method();
        ss1.super_method2();
        ss1.super_method3();

        ss1.get_sub_class_1_private_method();
        ss1.sub_1_method_2();
        ss1.sub_1_method_3();

        ss1.get_sub_sub_class_1_private_method();
        ss1.sub_sub_1_method_2();
        ss1.sub_sub_1_method_3();
        System.out.println();

        System.out.println("Implementing object created from sub sub class 2 with reference to same class");

        ss2.set_private_value(4);
        ss2.b=5;
        ss2.c=6;

        ss2.get_private_super_method();
        ss2.super_method2();
        ss2.super_method3();

        ss2.get_sub_class_1_private_method();
        ss2.sub_1_method_2();
        ss2.sub_1_method_3();

        ss2.get_sub_sub_class_2_private_method();
        ss2.sub_sub_2_method_2();
        ss2.sub_sub_2_method_3();
        System.out.println();

        System.out.println("Implementing object created from sub sub class 3 with reference to same class");
        ss3.set_private_value(7);
        ss3.b=8;
        ss3.c=9;

        ss3.get_private_super_method();
        ss3.super_method2();
        ss3.super_method3();

        ss3.get_sub_class_2_private_method();
        ss3.sub_2_method_2();
        ss3.sub_2_method_3();

        ss3.get_sub_sub_class_3_private_method();
        ss3.sub_sub_3_method_2();
        ss3.sub_sub_3_method_3();
        System.out.println();

        System.out.println("Implementing object created from sub sub class 4 with reference to same class");
        ss4.set_private_value(10);
        ss4.b=11;
        ss4.c=12;

        ss4.get_private_super_method();
        ss4.super_method2();
        ss4.super_method3();

        ss4.get_sub_class_2_private_method();
        ss4.sub_2_method_2();
        ss4.sub_2_method_3();

        ss4.get_sub_sub_class_4_private_method();
        ss4.sub_sub_4_method_2();
        ss4.sub_sub_4_method_3();
        System.out.println();

    }
}
