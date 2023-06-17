import java.util.*;
public class java_method_sum_4 {
    static void print(String s){
        for(int i=4;i>0;i--){
            for (int j=i;j>0;j--){
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
