class upper_class_single{
//    Class variables
    private String u_str_private;
    public String u_str_public;
    protected String u_str_protected;
//    Class constructor
    upper_class_single(String u_data1, String u_data2, String u_data3){
//        private variable is being set with this constructor
        this.u_str_private=u_data1;
        this.u_str_public=u_data2;
        this.u_str_protected=u_data3;
    }
//    Class method
    private String u_method_private(String data){
        return u_str_private + u_str_public + u_str_protected + "private u method"+data;
    }
    public String u_method_public(String data){
        return u_str_private + u_str_public + u_str_protected + "public u method"+data;
    }
    protected String u_method_protected(String data){
        return u_str_private + u_str_public + u_str_protected + "protected u method"+data;
    }
//    getter for private method
    String get_U_Method(String data){
        return u_method_private(data);
    }
}
class lower_class_single extends upper_class_single{
    //    Class variables
    private String l_str_private;
    public String l_str_public;
    protected String l_str_protected;
    //    Class constructor
    lower_class_single(String l_data1, String l_data2, String l_data3){
        super(l_data1,l_data2,l_data3);
        this.l_str_private=l_data1;
        this.l_str_public=l_data2;
        this.l_str_protected=l_data3;
    }
    //    Class method
    private String l_method_private(String data){
        return l_str_private + l_str_public + l_str_protected + "private l method"+data;
    }
    public String l_method_public(String data){
        return l_str_private + l_str_public + l_str_protected + "public l method"+data;
    }
    protected String l_method_protected(String data){
        return l_str_private + l_str_public + l_str_protected + "protected l method"+data;
    }
    //    getter for private method
    String get_L_Method(String data){
        return l_method_private(data);
    }
}
public class lab_single_inheritance {
    public static void main(String[] args) {

        System.out.println("hi");

//        creating object from super class with the reference from super class
//        upper_class_single test1 = new upper_class_single("private_v ", "public_v ","protected_v ");
////        System.out.println(test1.get_L_Method("passed"));
////        System.out.println(test1.l_method_public("passed"));
////        System.out.println(test1.l_method_protected("passed"));
//        System.out.println(test1.get_U_Method(" passed"));
//        System.out.println(test1.u_method_public(" passed"));
//        System.out.println(test1.u_method_protected(" passed"));

////        creating object from subclass with reference from super class
//        upper_class_single test2= new lower_class_single("private_v", "public_v","protected_v");
////        System.out.println(test2.get_L_Method("passed"));
////        System.out.println(test2.l_method_public("passed"));
////        System.out.println(test2.l_method_protected("passed"));
//        System.out.println(test2.get_U_Method("passed"));
//        System.out.println(test2.u_method_public("passed"));
//        System.out.println(test2.u_method_protected("passed"));

//        creating object from superclass with reference from subclass
//        lower_class_single test3 = new upper_class_single("private_v", "public_v","protected_v");
//        System.out.println(test3.get_L_Method("passed"));
//        System.out.println(test3.l_method_public("passed"));
//        System.out.println(test3.l_method_protected("passed"));
//        System.out.println(test3.u_method_public("passed"));
//        System.out.println(test3.get_U_Method("passed"));
//        System.out.println(test3.u_method_protected("passed"));

//        creating object from subclass with reference from subclass
        lower_class_single test4 = new lower_class_single("private_v ", "public_v ","protected_v ");
        System.out.println(test4.get_L_Method(" passed"));
        System.out.println(test4.l_method_public(" passed"));
        System.out.println(test4.l_method_protected(" passed"));
        System.out.println(test4.get_U_Method(" passed"));
        System.out.println(test4.u_method_public(" passed"));
        System.out.println(test4.u_method_protected(" passed"));

    }
}
