import java.util.*;
public class java_method_sum_3 {
    static int sum(int n){
       if(n==0){
           return 0;
       }
        return n+sum(n-1);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter value of n : ");
        int n=sc.nextInt();
        System.out.println("The sum of first "+n+" natural numbers is "+sum(n));
    }
}
