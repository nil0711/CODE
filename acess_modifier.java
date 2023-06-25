class acess_modifier_{
    public int a;
    private int b;
    protected int c;
    void set_value(int n){
        b=n;
    }
    int get_value(){
        return  b;
    }
    int print_a(){
        return a;
    }
    int print_b(){
        return get_value();
    }
    int print_c(){
        return c;
    }


}
public class acess_modifier {
    public static void main(String[] args) {
        acess_modifier_ test = new acess_modifier_();
        test.a=4;
        test.set_value(5);
        test.c=6;
        System.out.println(test.print_a());
        System.out.println(test.print_b());
        System.out.println(test.print_c());
    }
}
