import java.util.Scanner;
public class cgpa_calculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter marks of subject 1");
        float a=sc.nextFloat();
        System.out.println("Enter marks of subject 2");
        float b=sc.nextFloat();
        System.out.println("Enter marks of subject 3");
        float c=sc.nextFloat();
        float CGPA= (a+b+c)/3;
        System.out.print("CGPA is ");
        System.out.println(CGPA/9.5);
    }
}
