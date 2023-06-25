import java.util.*;
public class java_loop_sum9 {
    public static void main(String[] args) {
        int n=8;
        int sum=0;
        for(int i=1;i<=10;i++){
            sum=sum+(n*i);
            System.out.println(n+" * "+i+" = "+(n*i));
        }
        System.out.println("The sum of the numbers occuring in the multiplication table of 8 is "+sum);
    }
}
