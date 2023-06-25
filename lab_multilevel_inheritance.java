class upper_class_multilevel{
    //    Class variables
    private String u_str_private;
    public String u_str_public;
    protected String u_str_protected;
    //    Class constructor
    upper_class_multilevel(String u_data1, String u_data2, String u_data3){
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
class intermediate_lower_class_multilevel extends upper_class_multilevel{
    //    Class variables
    private String i_l_str_private;
    public String i_l_str_public;
    protected String i_l_str_protected;
    //    Class constructor
    intermediate_lower_class_multilevel(String i_l_data1, String i_l_data2, String i_l_data3){
        super(i_l_data1,i_l_data2,i_l_data3);
        this.i_l_str_private=i_l_data1;
        this.i_l_str_public=i_l_data2;
        this.i_l_str_protected=i_l_data3;
    }
    //    Class method
    private String i_l_method_private(String data){
        return i_l_str_private + i_l_str_public + i_l_str_protected + "private i l method"+data;
    }
    public String i_l_method_public(String data){
        return i_l_str_private + i_l_str_public + i_l_str_protected + "public i l method"+data;
    }
    protected String i_l_method_protected(String data){
        return i_l_str_private + i_l_str_public + i_l_str_protected + "protected i l method"+data;
    }
    //    getter for private method
    String get_i_L_Method(String data){
        return i_l_method_private(data);
    }
}
class lower_class_multilevel extends intermediate_lower_class_multilevel{
    //    Class variables
    private String l_str_private;
    public String l_str_public;
    protected String l_str_protected;
    //    Class constructor
    lower_class_multilevel(String l_data1, String l_data2, String l_data3){
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
public class lab_multilevel_inheritance {
    public static void main(String[] args) {


//        creating subclass object with reference from subclass reference
        lower_class_multilevel test1 = new lower_class_multilevel("private_v ", "public_v ","protected_v ");
        System.out.println(test1.get_L_Method(" passed"));
        System.out.println(test1.l_method_public(" passed"));
        System.out.println(test1.l_method_protected(" passed"));
        System.out.println(test1.get_i_L_Method(" passed"));
        System.out.println(test1.i_l_method_public(" passed"));
        System.out.println(test1.i_l_method_protected(" passed"));
        System.out.println(test1.get_U_Method(" passed"));
        System.out.println(test1.u_method_public(" passed"));
        System.out.println(test1.u_method_protected(" passed"));
    }
}
