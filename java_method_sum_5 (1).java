import java.util.*;
public class java_method_sum_5 {
    static int fibonacci(int n){
        if(n==2||n==3){
            return 1;
        }
        else if (n==1) {
            return 0;
        }
        int f= fibonacci(n-1)+fibonacci(n-2);
        return f;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter value of n : ");
        int n=sc.nextInt();
        System.out.println(n+" th fibonacci number is "+fibonacci(n));
    }
}
