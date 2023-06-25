//interface interface1_hyd{
//    default void get_private_method_from_interface1(){
//        method_interface_1();
//    }
//
//    int i1=100;
//    private void method_interface_1(){
//        System.out.println("Using private interface in interface 1");
//    }
//    public void method_interface1();
//
//}
//interface interface2_hyd{
//    default void get_private_method_from_interface2(){
//        method1();
//    }
//    int i2=200;
//    private void method1(){
//        System.out.println("Using private interface in interface 2");
//    }
//    void method_interface2();
//}
//class super_class_hyd{
//    private int a;
//    public int b;
//    protected int c;
//    void get_method(){
//        super_class_method1();
//    }
//    int get_private_value(){
//        return a;
//    }
//    void set_private_value(int p){
//        a=p;
//    }
//    private void super_class_method1(){
//        System.out.println("Using private method in Super class and printing private attribute with getters and setters "+get_private_value());
//    }
//    public void super_class_method2(){
//        System.out.println("Using public method in Super class and printing public attribute "+b);
//    }
//    protected void super_class_method3(){
//        System.out.println("Using protected method in Super class and printing protected attribute "+c);
//    }
//}
//class sub_class_hyd extends super_class_mi implements interface1,interface2{
//    void get_sub_class_method(){
//        sub_class_method1();
//    }
//    private void sub_class_method1(){
//        System.out.println("Using private method in Sub class and calling private method from super class using get method");
//        get_method();
//    }
//    public void sub_class_method2(){
//        System.out.println("Using public method in Sub class and calling public method from super class");
//        super_class_method2();
//    }
//    protected void sub_class_method3(){
//        System.out.println("Using protected method in Sub class and calling protected method from super class");
//        super_class_method3();
//    }
//
//    public void method_interface1(){
//        System.out.println("Using public method from interface 1 and printing public attribute "+interface1_hyd.i1);
//    }
//    public void method_interface2(){
//        System.out.println("Using public method from interface 2 and printing public attribute "+interface2_hyd.i2);
//    }
//}
//class sub_sub_hyd1 extends sub_class_hyd{
//    void get_method_sub_sub_h1(){
//        sub_sub_class_method1();
//    }
//    private void sub_sub_class_method1(){
//        System.out.println("Using private method from sub sub class 1 and calling private methods from super class and sub class");
//        get_method();
//        get_sub_class_method();
//    }
//    public void sub_sub_class_method2(){
//        System.out.println("Using public method from sub sub class 1 and calling public methods from super class and sub class");
//        super_class_method2();
//        sub_class_method2();
//    }
//    protected void sub_sub_class_method3(){
//        System.out.println("Using protected method from sub sub class 1 and calling protected methods from super class and sub class");
//        super_class_method3();
//        sub_class_method2();
//    }
//
//    @Override
//    public void method_interface1() {
//        super.method_interface1();
//    }
//
//    @Override
//    public void method_interface2() {
//        super.method_interface2();
//    }
//}
//class sub_sub_hyd2 extends sub_class_hyd{
//    void get_sub_sub_method_h2(){
//        sub_sub_class_method1();
//    }
//    private void sub_sub_class_method1(){
//        System.out.println("Using private method from sub sub class 1 and calling private methods from super class and sub class");
//        get_method();
//        get_sub_class_method();
//    }
//    public void sub_sub_class_method2(){
//        System.out.println("Using public method from sub sub class 1 and calling public methods from super class and sub class");
//        super_class_method2();
//        sub_class_method2();
//    }
//    protected void sub_sub_class_method3(){
//        System.out.println("Using protected method from sub sub class 1 and calling protected methods from super class and sub class");
//        super_class_method3();
//        sub_class_method3();
//    }
//
//    @Override
//    public void method_interface1() {
//        super.method_interface1();
//    }
//
//    @Override
//    public void method_interface2() {
//        super.method_interface2();
//    }
//}
//public class hybrid_inheritance_generic {
//    public static void main(String[] args) {
//
//        System.out.println("Creating object from sub sub class 1 with reference to same class");
//        sub_sub_hyd1 ssh1= new sub_sub_hyd1();
//        ssh1.set_private_value(1);
//        ssh1.b=2;
//        ssh1.c=3;
//
//        ssh1.get_method();
//        ssh1.super_class_method2();
//        ssh1.super_class_method3();
//
//        ssh1.get_sub_class_method();
//        ssh1.sub_class_method2();
//        ssh1.sub_class_method3();
//
//        ssh1.get_method_sub_sub_h1();
//        ssh1.sub_sub_class_method2();
//        ssh1.sub_sub_class_method3();
//
//        ssh1.method_interface1();
//        ssh1.method_interface2();
//        ssh1.get_private_method_from_interface1();
//        ssh1.get_private_method_from_interface2();
//        System.out.println();
//
//        System.out.println("Creating object from sub sub class 2 with reference to same class");
//
//        sub_sub_hyd2 ssh2= new sub_sub_hyd2();
//
//        ssh2.set_private_value(4);
//        ssh2.b=5;
//        ssh2.c=6;
//
//        ssh2.get_method();
//        ssh2.super_class_method2();
//        ssh2.super_class_method3();
//
//        ssh2.get_sub_class_method();
//        ssh2.sub_class_method2();
//        ssh2.sub_class_method3();
//
//        ssh2.get_sub_sub_method_h2();
//        ssh2.sub_sub_class_method2();
//        ssh2.sub_sub_class_method3();
//
//        ssh2.method_interface1();
//        ssh2.method_interface2();
//        ssh2.get_private_method_from_interface1();
//        ssh2.get_private_method_from_interface2();
//        System.out.println();
//
//    }
//}
