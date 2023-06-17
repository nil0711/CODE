import java.util.*;
public class java_array_sum_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the length of the array : ");
        int n = sc.nextByte();
        float[] test = new float[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter test[" + i + "] : ");
            test[i] = sc.nextFloat();
            System.out.print("\n");
        }
        System.out.print("Enter the integer you want to find : ");
        int f = sc.nextByte();
        boolean a = false;
        for (int i = 0; i < n; i++) {
            if (test[i] == f) {
                a = true;
            }
        }
        System.out.println(a);
    }}