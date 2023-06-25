interface k1{
    String k1="interface 1";
    String i1_method();
}
interface k2{
    String k2="interface 2";
    String i2_method();
}
class F implements k1,k2{
    public String var1;
    private String var2;
    protected String var3;
    F(String a, String b, String c){
        this.var1=a;
        this.var2=b;
        this.var3=c;
    }
    public String sup_met_1(){
        System.out.println("This is public method of super class");
        return var1;
    }
    private String sup_met_2(){
        System.out.println("This is private method of super class");
        return var2;
    }
    protected String sup_met_3(){
        System.out.println("This is protected method of super class");
        return var3;
    }
    String getSupMethod(){
        return sup_met_2();
    }
    @Override
    public String i1_method() {
        System.out.println("Using interface 1");
        return k1;
    }
    @Override
    public String i2_method() {
        System.out.println("Using interface 2");
        return k2;
    }
}
class H extends  F{
    public String var1;
    private String var2;
    protected String var3;
    H(String a, String b, String c){
        super(a,b,c);
        this.var1=a;
        this.var2=b;
        this.var3=c;
    }
    public String sub_met_1(){
        System.out.println("This is public method of sub class");
        return var1;
    }
    private String sub_met_2(){
        System.out.println("This is private method of sub class");
        return var2;
    }
    protected String sub_met_3(){
        System.out.println("This is protected method of sub class");
        return var3;
    }
    String getSubMethod(){
        return sub_met_2();
    }
}
public class hybrid_inheritance_class {
    public static void main(String[] args) {
        H test1=new H("sub1","sub2","sub3");
        System.out.println(test1.sub_met_1());
        System.out.println(test1.getSubMethod());
        System.out.println(test1.sub_met_3());
        System.out.println(test1.sup_met_1());
        System.out.println(test1.getSupMethod());
        System.out.println(test1.sup_met_3());
        System.out.println(test1.i1_method());
        System.out.println(test1.i2_method());
    }
}
