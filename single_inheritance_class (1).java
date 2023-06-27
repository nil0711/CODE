class A{
    public String var1;
    private String var2;
    protected String var3;
    A(String a, String b, String c){
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
class B extends A{
    public String var1;
    private String var2;
    protected String var3;
    B(String a, String b, String c){
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
public class single_inheritance_class {
    public static void main(String[] args) {
        //    creating an object from B with reference from B
        B test1=new B("sub1","sub2","sub3");
        System.out.println(test1.sub_met_1());
        System.out.println(test1.getSubMethod());
        System.out.println(test1.sub_met_3());
        System.out.println(test1.sup_met_1());
        System.out.println(test1.getSupMethod());
        System.out.println(test1.sup_met_3());
        System.out.println();
//    creating an object from B with reference from A
        A test2=new B("sup1","sup2","sup3");
//        System.out.println(test2.sub_met_1());
//        System.out.println(test2.getSubMethod());
//        System.out.println(test2.sub_met_3());
        System.out.println(test2.sup_met_1());
        System.out.println(test2.getSupMethod());
        System.out.println(test2.sup_met_3());
        System.out.println();
    }
}
