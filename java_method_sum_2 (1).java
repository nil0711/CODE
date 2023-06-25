import java.util.*;
public class java_method_sum_2 {
    static void print(String s){
        for(int i=1;i<=4;i++){
            for(int j=1;j<=i;j++){
                System.out.print(s);
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the symbol you want to print : ");
        String s=sc.next();
        System.out.println("The pattern is: ");
        print(s);

    }
}
