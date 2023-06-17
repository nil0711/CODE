import java.util.*;
public class java_loop_sum_2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter number : ");
        int n= sc.nextInt();
        int sum=0;
        for(int i=1;i<=n;i++){
            sum+=i;
        }
        System.out.print("The sum of first "+n+" natural number is ");
        System.out.println(sum);
    }
}
