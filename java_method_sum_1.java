import java.util.*;
public class java_method_sum_1 {
    static void table(int n){
        for(int i=1;i<=10;i++){
            System.out.println(n+" * "+i+" = "+(n*i));
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number : ");
        int n= sc.nextInt();
        System.out.println("The multiplication table of the number "+n+" is ");
        table(n);
    }
}
