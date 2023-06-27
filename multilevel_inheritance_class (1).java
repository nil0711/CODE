class A_{
    public String var1;
    private String var2;
    protected String var3;
    A_(String a, String b, String c){
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
}
class B_ extends A_{
    public String var1;
    private String var2;
    protected String var3;
    B_(String a, String b, String c){
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
class C extends B_{
    public String var1;
    private String var2;
    protected String var3;
    C(String a, String b, String c){
        super(a,b,c);
        this.var1=a;
        this.var2=b;
        this.var3=c;
    }

    public String sub_sub_met_1(){
        System.out.println("This is public method of sub_sub class");
        return var1;
    }
    private String sub_sub_met_2(){
        System.out.println("This is private method of sub_sub class");
        return var2;
    }
    protected String sub_sub_met_3(){
        System.out.println("This is protected method of sub_sub class");
        return var3;
    }
    String getSubSubMethod(){
        return sub_sub_met_2();
    }
}
public class multilevel_inheritance_class {
    public static void main(String[] args) {
        //    creating an object from C with reference from C
        C test1=new C("sub_sub1","sub_sub2","sub_sub3");
        System.out.println(test1.sub_sub_met_1());
        System.out.println(test1.getSubSubMethod());
        System.out.println(test1.sub_sub_met_3());
        System.out.println(test1.sub_met_1());
        System.out.println(test1.getSubMethod());
        System.out.println(test1.sub_met_3());
        System.out.println(test1.sup_met_1());
        System.out.println(test1.getSupMethod());
        System.out.println(test1.sup_met_3());
        System.out.println();
    }
}
