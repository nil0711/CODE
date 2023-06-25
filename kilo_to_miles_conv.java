import java.util.Scanner;
public class kilo_to_miles_conv {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter the length in kilo meters");
        float a=sc.nextFloat();
        System.out.print("The length in miles is ");
        System.out.println(a/1.6);
    }
}
