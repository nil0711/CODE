interface a1{
    String a1="interface 1";
    String i1_method();
}
interface a2{
    String a2="interface 2";
    String i2_method();
}
class _A implements a1,a2{
    public String var1;
    private String var2;
    protected String var3;
    _A(String a, String b, String c){
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
        return a1;
    }

    @Override
    public String i2_method() {
        System.out.println("Using interface 2");
        return a2;
    }
}
public class multiple_inheritance_class {
    public static void main(String[] args) {
        //    creating an object from _A with reference from _A
        _A test1=new _A("sup1","sup2","sup3");
        System.out.println(test1.sup_met_1());
        System.out.println(test1.getSupMethod());
        System.out.println(test1.sup_met_3());
        System.out.println(test1.i1_method());
        System.out.println(test1.i2_method());
        System.out.println();
    }
}
