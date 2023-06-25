import java.util.Scanner;
public class conditional_statement_sum2 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter website");
        String website=sc.next();
        if(website.endsWith(".com")){
            System.out.println("It is a commercial website");
        }
        else if (website.endsWith(".org")) {
            System.out.println("It is a organization website");
        }
        else if (website.endsWith(".in")) {
            System.out.println("It is a organization website");
        }
        else {
            System.out.println("Insufficient data");
        }
    }
}
