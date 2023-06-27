class _A_{
    public String var1;
    private String var2;
    protected String var3;
    _A_(String a, String b, String c){
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
class _B_ extends _A_{
    public String var1;
    private String var2;
    protected String var3;
    _B_(String a, String b, String c){
        super(a,b,c);
        this.var1=a;
        this.var2=b;
        this.var3=c;
    }

    public String left_met_1(){
        System.out.println("This is public method of left class");
        return var1;
    }
    private String left_met_2(){
        System.out.println("This is private method of left class");
        return var2;
    }
    protected String left_met_3(){
        System.out.println("This is protected method of left class");
        return var3;
    }
    String getLeftMethod(){
        return left_met_2();
    }
}
class C_ extends  _A_{
    public String var1;
    private String var2;
    protected String var3;
    C_(String a, String b, String c){
        super(a,b,c);
        this.var1=a;
        this.var2=b;
        this.var3=c;
    }

    public String right_met_1(){
        System.out.println("This is public method of right class");
        return var1;
    }
    private String right_met_2(){
        System.out.println("This is private method of right class");
        return var2;
    }
    protected String right_met_3(){
        System.out.println("This is protected method of right class");
        return var3;
    }
    String getRightMethod(){
        return right_met_2();
    }
}
class  D extends C_{
    public String var1;
    private String var2;
    protected String var3;
    D(String a, String b, String c){
        super(a,b,c);
        this.var1=a;
        this.var2=b;
        this.var3=c;
    }

    public String left_right_met_1(){
        System.out.println("This is public method of left_right class");
        return var1;
    }
    private String left_right_met_2(){
        System.out.println("This is private method of left_right class");
        return var2;
    }
    protected String left_right_met_3(){
        System.out.println("This is protected method of left_right class");
        return var3;
    }
    String getLeftRightMethod(){
        return left_right_met_2();
    }
}
class E extends C_{
    public String var1;
    private String var2;
    protected String var3;
    E(String a, String b, String c){
        super(a,b,c);
        this.var1=a;
        this.var2=b;
        this.var3=c;
    }
    public String right_right_met_1(){
        System.out.println("This is public method of right_right class");
        return var1;
    }
    private String right_right_met_2(){
        System.out.println("This is private method of right_right class");
        return var2;
    }
    protected String right_right_met_3(){
        System.out.println("This is protected method of right_right class");
        return var3;
    }
    String getRightRightMethod(){
        return right_right_met_2();
    }
}
public class hierarchical_inheritance_class {
    public static void main(String[] args) {
//        creating object from D with reference from D
        D test2=new D("left_right1","left_right2","left_right3");
        System.out.println(test2.left_right_met_1());
        System.out.println(test2.getLeftRightMethod());
        System.out.println(test2.left_right_met_3());
        System.out.println(test2.right_met_1());
        System.out.println(test2.getRightMethod());
        System.out.println(test2.right_met_3());
        System.out.println(test2.sup_met_1());
        System.out.println(test2.getSupMethod());
        System.out.println(test2.sup_met_3());
        System.out.println();
//        creating object from E with reference from E
        E test3=new E("right_right1","right_right2","right_right3");
        System.out.println(test3.right_right_met_1());
        System.out.println(test3.getRightRightMethod());
        System.out.println(test3.right_right_met_3());
        System.out.println(test3.right_met_1());
        System.out.println(test3.getRightMethod());
        System.out.println(test3.right_met_3());
        System.out.println(test3.sup_met_1());
        System.out.println(test3.getSupMethod());
        System.out.println(test3.sup_met_3());
        System.out.println();
    }
}
