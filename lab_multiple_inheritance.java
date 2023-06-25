interface i1{
    //    Interface variables
    String i1_str_public ="interface 1";

    //    Interface constructor
//    i2( String i1_data2){
////        private variable is being set with this constructor
//        this.i1_str_public=i1_data2;
//
//    }
    //    Interface method
    private String i1_method_private(String data){
        return i1_str_public + "private i1 method"+data;
    }
    default String i1_method_public(String data){
        return i1_str_public + "public i1 method"+data;
    }
//    protected String i1_method_protected(String data){
//        return i1_str_public + "protected i1 method"+data;
//    }
    //    getter for private method
default String get_i1_Method(String data){
        return i1_method_private(data);
    }
}
interface i2{
    //    Interface variables
    String i2_str_public ="interface 2";

    //    Interface method
    private String i2_method_private(String data){
        return i2_str_public + "private i2 method"+data;
    }
    default String i2_method_public(String data){
        return i2_str_public + "public i2 method"+data;
    }

    //    getter for private method
    default String get_i2_Method(String data){
        return i2_method_private(data);
    }
}
class upperclass1_multiple{
    //    Class variables
    private String u1_str_private;
    public String u1_str_public;
    protected String u1_str_protected;
    //    Class constructor
    upperclass1_multiple(String u1_data1, String u1_data2, String u1_data3){
//        private variable is being set with this constructor
        this.u1_str_private=u1_data1;
        this.u1_str_public=u1_data2;
        this.u1_str_protected=u1_data3;
    }
    //    Class method
    private String u1_method_private(String data){
        return u1_str_private + u1_str_public + u1_str_protected + "private u1 method"+data;
    }
    public String u1_method_public(String data){
        return u1_str_private + u1_str_public + u1_str_protected + "public u1 method"+data;
    }
    protected String u1_method_protected(String data){
        return u1_str_private + u1_str_public + u1_str_protected + "protected u1 method"+data;
    }
    //    getter for private method
    String get_U_Method(String data){
        return u1_method_private(data);
    }
}
//class upperclass2_multiple{
//    String u2_str;
//    upperclass2_multiple(String u2_data){
//        this.u2_str=u2_data;
//    }
//    String u2_method(String data){
//        return data;
//    }
//}
//class lowerclass_multiple extends upperclass1_multiple, upperclass2_multiple{
//    private String l_str1;
//    public String l_str2;
//    protected String l_str3;
//    lowerclass_multiple(String l_data1,String l_data2,String l_data3){
//        super(l_data1,l_data2,l_data3);
//        this.l_str1=l_data1;
//        this.l_str2=l_data2;
//        this.l_str3=l_data3;
//    }
//    String l_method(String data){
//        return data;
//    }
//}
class lower_class_multiple extends upperclass1_multiple implements i1, i2{
    //    Class variables
    private String l_str_private;
    public String l_str_public;
    protected String l_str_protected;
//        Class constructor
    lower_class_multiple(String l_data1, String l_data2, String l_data3){
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

public class lab_multiple_inheritance {
    public static void main(String[] args) {
        lower_class_multiple test1 = new lower_class_multiple("private_v ","public_v ","protected_v ");
        System.out.println(test1.get_L_Method(" passed"));
        System.out.println(test1.l_method_public(" passed"));
        System.out.println(test1.l_method_protected(" passed"));
        System.out.println(test1.get_U_Method(" passed"));
        System.out.println(test1.u1_method_public(" passed"));
        System.out.println(test1.u1_method_protected(" passed"));
        System.out.println(test1.get_i1_Method(" passed"));
        System.out.println((test1.i1_method_public(" passed")));
        System.out.println(test1.get_i2_Method(" passed"));
        System.out.println(test1.i2_method_public(" passed"));

    }

}
