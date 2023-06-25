interface i1_hybrid{
    //    Interface variables
    String i1_str_public ="interface 1";


    //    Interface method
    private String i1_method_private(String data){
        return i1_str_public + "private i1 method"+data;
    }
    default String i1_method_public(String data){
        return i1_str_public + "public i1 method"+data;
    }

    //    getter for private method
    default String get_i1_Method(String data){
        return i1_method_private(data);
    }
}
interface i2_hybrid{
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
class upper_class_hybrid implements i1_hybrid,i2_hybrid{
    //    Class variables
    private String u_str_private;
    public String u_str_public;
    protected String u_str_protected;
    //    Class constructor
    upper_class_hybrid(String u_data1, String u_data2, String u_data3){
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
class lower_class_hybrid extends upper_class_hybrid{
    //    Class variables
    private String l_str_private;
    public String l_str_public;
    protected String l_str_protected;
    //    Class constructor
    lower_class_hybrid(String l_data1, String l_data2, String l_data3){
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
public class lab_hybrid_inheritance {
    public static void main(String[] args) {


//        creating object from lower class with reference from upper class
        lower_class_hybrid test1=new lower_class_hybrid("private_v ","public_v ","protected_v ");
        System.out.println(test1.get_L_Method(" passed"));
        System.out.println(test1.l_method_public(" passed"));
        System.out.println(test1.l_method_protected(" passed"));
        System.out.println(test1.get_U_Method(" passed"));
        System.out.println(test1.u_method_public(" passed"));
        System.out.println(test1.u_method_protected(" passed"));
        System.out.println(test1.get_i1_Method(" passed"));
        System.out.println(test1.i1_method_public(" passed"));
        System.out.println(test1.get_i2_Method(" passed"));
        System.out.println(test1.i2_method_public(" passed"));
    }
}
