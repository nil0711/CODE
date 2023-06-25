import java.util.*;
public class java_loop_sum_5 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter number: ");
        int n= sc.nextInt();
        int factorial=1;
        for(int i=n;i>=1;i--){
            factorial*=i;
        }
        System.out.println("The factorial of the number "+n+" is "+factorial);
    }
}