import java.util.*;
public class java_loop_sum3 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter a number");
        int n= sc.nextInt();
        for (int i=n;i>0;i--){
            System.out.println(n+" * "+i+" = "+(n*i));
        }
    }
}
