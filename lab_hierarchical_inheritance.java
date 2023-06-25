class upper_class_hierarchical{
    //    Class variables
    private String u_str_private;
    public String u_str_public;
    protected String u_str_protected;
    //    Class constructor
    upper_class_hierarchical(String u_data1, String u_data2, String u_data3){
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
class intermediate_left_lower_class_hierarchical extends upper_class_hierarchical{
    //    Class variables
    private String i_l_l_str_private;
    public String i_l_l_str_public;
    protected String i_l_l_str_protected;
    //    Class constructor
    intermediate_left_lower_class_hierarchical(String i_l_l_data1, String i_l_l_data2, String i_l_l_data3){
        super(i_l_l_data1,i_l_l_data2,i_l_l_data3);
//        private variable is being set with this constructor
        this.i_l_l_str_private=i_l_l_data1;
        this.i_l_l_str_public=i_l_l_data2;
        this.i_l_l_str_protected=i_l_l_data3;
    }
    //    Class method
    private String i_l_l_method_private(String data){
        return i_l_l_str_private + i_l_l_str_public + i_l_l_str_protected + "private i l method"+data;
    }
    public String i_l_l_method_public(String data){
        return i_l_l_str_private + i_l_l_str_public + i_l_l_str_protected + "public i l method"+data;
    }
    protected String i_l_l_method_protected(String data){
        return i_l_l_str_private + i_l_l_str_public + i_l_l_str_protected + "protected i l method"+data;
    }
    //    getter for private method
    String get_i_l_l_Method(String data){
        return i_l_l_method_private(data);
    }
}
class intermediate_right_lower_class_hierarchical extends upper_class_hierarchical{
    //    Class variables
    private String i_r_l_str_private;
    public String i_r_l_str_public;
    protected String i_r_l_str_protected;
    //    Class constructor
    intermediate_right_lower_class_hierarchical(String i_r_l_data1, String i_r_l_data2, String i_r_l_data3){
        super(i_r_l_data1,i_r_l_data2,i_r_l_data3);
//        private variable is being set with this constructor
        this.i_r_l_str_private=i_r_l_data1;
        this.i_r_l_str_public=i_r_l_data2;
        this.i_r_l_str_protected=i_r_l_data3;
    }
    //    Class method
    private String i_r_l_method_private(String data){
        return i_r_l_str_private + i_r_l_str_public + i_r_l_str_protected + "private i r method"+data;
    }
    public String i_r_l_method_public(String data){
        return i_r_l_str_private + i_r_l_str_public + i_r_l_str_protected + "public i r method"+data;
    }
    protected String i_r_l_method_protected(String data){
        return i_r_l_str_private + i_r_l_str_public + i_r_l_str_protected + "protected i r method"+data;
    }
    //    getter for private method
    String get_i_r_l_Method(String data){
        return i_r_l_method_private(data);
    }
}
class left_left_lower_class_hierarchical extends intermediate_left_lower_class_hierarchical{
    //    Class variables
    private String l_l_l_str_private;
    public String l_l_l_str_public;
    protected String l_l_l_str_protected;
    //    Class constructor
    left_left_lower_class_hierarchical(String l_l_l_data1, String l_l_l_data2, String l_l_l_data3){
        super(l_l_l_data1,l_l_l_data2,l_l_l_data3);
//        private variable is being set with this constructor
        this.l_l_l_str_private=l_l_l_data1;
        this.l_l_l_str_public=l_l_l_data2;
        this.l_l_l_str_protected=l_l_l_data3;
    }
    //    Class method
    private String l_l_l_method_private(String data){
        return l_l_l_str_private + l_l_l_str_public + l_l_l_str_protected + "private l l method"+data;
    }
    public String l_l_l_method_public(String data){
        return l_l_l_str_private + l_l_l_str_public + l_l_l_str_protected + "public l l method"+data;
    }
    protected String l_l_l_method_protected(String data){
        return l_l_l_str_private + l_l_l_str_public + l_l_l_str_protected + "protected l l method"+data;
    }
    //    getter for private method
    String get_l_l_l_Method(String data){
        return l_l_l_method_private(data);
    }
}
class right_left_lower_class_hierarchical extends intermediate_left_lower_class_hierarchical{
    //    Class variables
    private String r_l_l_str_private;
    public String r_l_l_str_public;
    protected String r_l_l_str_protected;
    //    Class constructor
    right_left_lower_class_hierarchical(String r_l_l_data1, String r_l_l_data2, String r_l_l_data3){
        super(r_l_l_data1,r_l_l_data2,r_l_l_data3);
//        private variable is being set with this constructor
        this.r_l_l_str_private=r_l_l_data1;
        this.r_l_l_str_public=r_l_l_data2;
        this.r_l_l_str_protected=r_l_l_data3;
    }
    //    Class method
    private String r_l_l_method_private(String data){
        return r_l_l_str_private + r_l_l_str_public + r_l_l_str_protected + "private r l method"+data;
    }
    public String r_l_l_method_public(String data){
        return r_l_l_str_private + r_l_l_str_public + r_l_l_str_protected + "public r l method"+data;
    }
    protected String r_l_l_method_protected(String data){
        return r_l_l_str_private + r_l_l_str_public + r_l_l_str_protected + "protected r l method"+data;
    }
    //    getter for private method
    String get_r_l_l_Method(String data){
        return r_l_l_method_private(data);
    }
}
class left_right_lower_class_hierarchical extends intermediate_right_lower_class_hierarchical{
    //    Class variables
    private String l_r_l_str_private;
    public String l_r_l_str_public;
    protected String l_r_l_str_protected;
    //    Class constructor
    left_right_lower_class_hierarchical(String l_r_l_data1, String l_r_l_data2, String l_r_l_data3){
        super(l_r_l_data1,l_r_l_data2,l_r_l_data3);
//        private variable is being set with this constructor
        this.l_r_l_str_private=l_r_l_data1;
        this.l_r_l_str_public=l_r_l_data2;
        this.l_r_l_str_protected=l_r_l_data3;
    }
    //    Class method
    private String l_r_l_method_private(String data){
        return l_r_l_str_private + l_r_l_str_public + l_r_l_str_protected + "private l r method"+data;
    }
    public String l_r_l_method_public(String data){
        return l_r_l_str_private + l_r_l_str_public + l_r_l_str_protected + "public l r method"+data;
    }
    protected String l_r_l_method_protected(String data){
        return l_r_l_str_private + l_r_l_str_public + l_r_l_str_protected + "protected l r method"+data;
    }
    //    getter for private method
    String get_l_r_l_Method(String data){
        return l_r_l_method_private(data);
    }
}
class right_right_lower_class_hierarchical extends intermediate_right_lower_class_hierarchical{
    //    Class variables
    private String r_r_l_str_private;
    public String r_r_l_str_public;
    protected String r_r_l_str_protected;
    //    Class constructor
    right_right_lower_class_hierarchical(String r_r_l_data1, String r_r_l_data2, String r_r_l_data3){
        super(r_r_l_data1,r_r_l_data2,r_r_l_data3);
//        private variable is being set with this constructor
        this.r_r_l_str_private=r_r_l_data1;
        this.r_r_l_str_public=r_r_l_data2;
        this.r_r_l_str_protected=r_r_l_data3;
    }
    //    Class method
    private String r_r_l_method_private(String data){
        return r_r_l_str_private + r_r_l_str_public + r_r_l_str_protected + "private r r method"+data;
    }
    public String r_r_l_method_public(String data){
        return r_r_l_str_private + r_r_l_str_public + r_r_l_str_protected + "public r r method"+data;
    }
    protected String r_r_l_method_protected(String data){
        return r_r_l_str_private + r_r_l_str_public + r_r_l_str_protected + "protected r r method"+data;
    }
    //    getter for private method
    String get_r_r_l_Method(String data){
        return r_r_l_method_private(data);
    }
}
public class lab_hierarchical_inheritance {
    public static void main(String[] args) {


//        creating left left lower class object from left left lower class reference
        left_left_lower_class_hierarchical test1 = new left_left_lower_class_hierarchical("private_v ","public_v ","protected_v ");
        System.out.println(test1.get_l_l_l_Method(" passed"));
        System.out.println(test1.l_l_l_method_public(" passed"));
        System.out.println(test1.l_l_l_method_protected(" passed"));
        System.out.println(test1.get_i_l_l_Method(" passed"));
        System.out.println(test1.i_l_l_method_public(" passed"));
        System.out.println(test1.i_l_l_method_protected(" passed"));
        System.out.println(test1.get_U_Method(" passed"));
        System.out.println(test1.u_method_public(" passed"));
        System.out.println(test1.u_method_protected(" passed"));


//        creating right left lower class object from right left lower class reference
        right_left_lower_class_hierarchical test2 = new right_left_lower_class_hierarchical("private_v ","public_v ","protected_v ");
        System.out.println(test2.get_r_l_l_Method(" passed"));
        System.out.println(test2.r_l_l_method_public(" passed"));
        System.out.println(test2.r_l_l_method_protected(" passed"));
        System.out.println(test2.get_i_l_l_Method(" passed"));
        System.out.println(test2.i_l_l_method_public(" passed"));
        System.out.println(test2.i_l_l_method_protected(" passed"));
        System.out.println(test2.get_U_Method(" passed"));
        System.out.println(test2.u_method_public(" passed"));
        System.out.println(test2.u_method_protected(" passed"));

//        creating left right lower class object from left right lower class reference
        left_right_lower_class_hierarchical test3 = new left_right_lower_class_hierarchical("private_v ","public_v ","protected_v ");
        System.out.println(test3.get_l_r_l_Method(" passed"));
        System.out.println(test3.l_r_l_method_public(" passed"));
        System.out.println(test3.l_r_l_method_protected(" passed"));
        System.out.println(test3.get_i_r_l_Method(" passed"));
        System.out.println(test3.i_r_l_method_public(" passed"));
        System.out.println(test3.i_r_l_method_protected(" passed"));
        System.out.println(test3.get_U_Method(" passed"));
        System.out.println(test3.u_method_public(" passed"));
        System.out.println(test3.u_method_protected(" passed"));

//        creating right right lower class object from right right lower class reference
        right_right_lower_class_hierarchical test4 = new right_right_lower_class_hierarchical("private_v ","public_v ","protected_v ");
        System.out.println(test4.get_r_r_l_Method(" passed"));
        System.out.println(test4.r_r_l_method_public(" passed"));
        System.out.println(test4.r_r_l_method_protected(" passed"));
        System.out.println(test4.get_i_r_l_Method(" passed"));
        System.out.println(test4.i_r_l_method_public(" passed"));
        System.out.println(test4.i_r_l_method_protected(" passed"));
        System.out.println(test4.get_U_Method(" passed"));
        System.out.println(test4.u_method_public(" passed"));
        System.out.println(test4.u_method_protected(" passed"));


////        creating object from a class with reference from a sibling class
////        creating object from right left lower class with reference from left left lower
//
//        left_left_lower_class_hierarchical test5= new right_left_lower_class_hierarchical("private_v ","public_v ","protected_v ");
//        System.out.println(test5.get_l_l_l_Method(" passed"));
//        System.out.println(test5.l_l_l_method_public(" passed"));
//        System.out.println(test5.l_l_l_method_protected(" passed"));
//        System.out.println(test5.get_i_l_l_Method(" passed"));
//        System.out.println(test5.i_l_l_method_public(" passed"));
//        System.out.println(test5.i_l_l_method_protected(" passed"));
//        System.out.println(test5.get_U_Method(" passed"));
//        System.out.println(test5.u_method_public(" passed"));
//        System.out.println(test5.u_method_protected(" passed"));

////        creating object from a class with reference from a cousin class
////        creating object from left left lower class with reference from right right lower class
//        right_right_lower_class_hierarchical test6 = new left_left_lower_class_hierarchical("private_v ","public_v ","protected_v ");
//        System.out.println(test6.get_r_r_l_Method(" passed"));
//        System.out.println(test6.r_r_l_method_public(" passed"));
//        System.out.println(test6.r_r_l_method_protected(" passed"));
//        System.out.println(test6.get_i_r_l_Method(" passed"));
//        System.out.println(test6.i_r_l_method_public(" passed"));
//        System.out.println(test6.i_r_l_method_protected(" passed"));
//        System.out.println(test6.get_U_Method(" passed"));
//        System.out.println(test6.u_method_public(" passed"));
//        System.out.println(test6.u_method_protected(" passed"));

    }
}
