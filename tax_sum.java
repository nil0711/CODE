import java.util.Scanner;
public class tax_sum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your annual income in lakhs");
        Float income=sc.nextFloat();
        if(income >= 2.5 && income < 5.0){
            System.out.println("You'll pay 5% tax");
        }
        else if (income >= 5 && income < 10.0) {
            System.out.println("You'll pay 20% tax");
        }
        else if (income > 10) {
            System.out.println("You'll pay 30% tax");
        }
        else {
            System.out.println("No tax.");
        }
//
    }
}
