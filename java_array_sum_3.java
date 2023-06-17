import java.util.*;
public class java_array_sum_3 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the number of students : ");
        int n= sc.nextByte();
        float [] marks=new float[n];
        for (int i=0;i<n;i++){
            System.out.print("Enter marks of Student "+i+" : ");
            marks[i]= sc.nextFloat();
            System.out.print("\n");
        }
        float sum=0.0f;
        for (float mark:marks) {
            sum=sum+mark;
        }
        float avg=sum/n;
        System.out.println(avg);
        }
    }

