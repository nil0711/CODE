interface interface1{
     default int get_private_method_from_interface1(){
       return method_interface_1();
    }

     int i1=100;
    private int method_interface_1(){
        return 89;
    }
    public int method_interface1();

}
interface interface2{
    default int get_private_method_from_interface2(){
        return method1();
    }
   int i2=200;
    private int method1(){
        return 99;
    }
     int method_interface2();
}
class super_class_mi{
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
    public int super_class_method2(){
        return b;
    }
    protected int super_class_method3(){
        return c;
    }
}
class sub_class_mi extends super_class_mi implements interface1,interface2{
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

    public int method_interface1(){
       return interface1.i1;
    }
    public int method_interface2(){
        return interface2.i2;
    }

}
public class multiple_inheritance_generic {
    public static void main(String[] args) {
           sub_class_mi ss =new  sub_class_mi();
           ss.set_private_value(1);
//           ss
    }
}
