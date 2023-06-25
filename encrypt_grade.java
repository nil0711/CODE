import java.util.Scanner;

public class encrypt_grade {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        System.out.println("Enter grade :");
        int a = sc.nextInt();
        a+=8;
        System.out.println("The grade is encrypted."+"The encrypted grade is "+a);
        System.out.print("The decrypted grade is ");
        System.out.println(a-8);
    }
}
