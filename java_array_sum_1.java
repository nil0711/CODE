import java.util.*;
public class java_array_sum_1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        float [] test=new float[5];
        for (int i=0;i<5;i++){
            System.out.print("Enter test["+i+"] : ");
            test[i]= sc.nextFloat();
            System.out.print("\n");
        }
        float sum=0;
        for (int i=0;i<5;i++){
            sum=sum+test[i];
        }
        System.out.println(sum);
    }
}
