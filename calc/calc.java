package calc;
import java.util.*;
class normal_calc{
    double sum(double a ,double b){
        return a+b;
    }
    double minus(double a ,double b){
       return a-b;
    }
    double multiply(double a ,double b){
        return a*b;
    }
    double root(double a){
        return Math.sqrt(a);
    }
    double pow(double a){
        return Math.pow(a, 2);
    }
}
class Sc_calc extends normal_calc{
    double cos(double a){
        return Math.cos(a);
    }
}
class hybrid_calc extends Sc_calc{
    double side_of_triangle(double a, double b, double c){
        return root(minus((sum(pow(a),pow(b))),multiply(multiply(2,a),multiply(b,cos(c)))));
    }
}
public class calc {
    public static void main(String[] args) {
        hybrid_calc h=new hybrid_calc();
        System.out.println(h.side_of_triangle(3,4,3.14/2));
//        System.out.println(h.cos(90));
    }
}
