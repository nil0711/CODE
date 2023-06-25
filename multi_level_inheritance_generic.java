class super_class_ml{
    private int a;
    public int b;
    protected int c;
    void get_method(){
        super_class_method1();
    }
    int get_private_value(){
        return a;
    }
    void set_private_value(int p){
        a=p;
    }
    private void super_class_method1(){
        System.out.println("Using private method in Super class and printing private attribute with getters and setters "+get_private_value());
    }
    public void super_class_method2(){
        System.out.println("Using public method in Super class and printing public attribute "+b);
    }
    protected void super_class_method3(){
        System.out.println("Using protected method in Super class and printing protected attribute "+c);
    }
}
class sub_class_ml extends super_class_ml {

    void get_sub_method(){
        sub_class_method1();
    }
    private void sub_class_method1(){
        System.out.println("Using private method in Sub class and calling private method from super class using get method");
        get_method();
    }
    public void sub_class_method2(){
        System.out.println("Using public method in Sub class and calling public method from super class");
        super_class_method2();
    }
    protected void sub_class_method3(){
        System.out.println("Using protected method in Sub class and calling protected method from super class");
        super_class_method3();
    }
}
class sub_sub_class_ml extends sub_class_ml{
    void get_sub_sub_class_method(){
        sub_sub_class_method1();
    }
    private void sub_sub_class_method1(){
        System.out.println("Using private method in sub sub class and calling private method from sub class and super class");
        get_sub_method();
        get_method();
    }
    public void sub_sub_class_method2(){
        System.out.println("Using public method in sub sub class and calling public method from sub class and super class");
        sub_class_method2();
        super_class_method2();
    }
    protected void sub_sub_class_method3(){
        System.out.println("Using protected method in sub sub class and calling protected method from sub class and super class");
        sub_class_method3();
        super_class_method3();
    }
}
public class multi_level_inheritance_generic {
    public static void main(String[] args) {
        System.out.println("Creating super class object from super class reference");
            super_class_ml sp= new super_class_ml();
            sp.set_private_value(1);
            sp.b=2;
            sp.c=3;

            sp.get_method();
            sp.super_class_method2();
            sp.super_class_method3();
        System.out.println();

        System.out.println("Creating sub class object from sub class reference");

            sub_class_ml sb=new sub_class_ml();
            sb.set_private_value(4);
            sb.b=5;
            sb.c=6;

            sb.get_sub_method();
            sb.sub_class_method2();
            sb.sub_class_method3();
        System.out.println();

        System.out.println("Creating sub sub class object from sub sub class reference");

            sub_sub_class_ml ssb=new sub_sub_class_ml();

            ssb.set_private_value(7);
            ssb.b=8;
            ssb.c=9;

            ssb.get_sub_sub_class_method();
            ssb.sub_sub_class_method2();
            ssb.sub_sub_class_method3();
        System.out.println();

        System.out.println("Creating sub sub class object from super class reference");

            super_class_ml ss=new sub_sub_class_ml();

            ss.set_private_value(10);
            ss.b=11;
            ss.c=12;

            ss.get_method();
            ss.super_class_method2();
            ss.super_class_method3();
        System.out.println();

        System.out.println("Creating sub sub class object from sub class reference");

            sub_class_ml ssp=new sub_sub_class_ml();

            ssp.set_private_value(13);
            ssp.b=14;
            ssp.c=15;

            ssp.get_method();
            ssp.super_class_method2();
            ssp.super_class_method3();

            ssp.get_sub_method();
            ssp.sub_class_method2();
            ssp.sub_class_method3();

    }
}

