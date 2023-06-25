import java.util.Scanner;
public class conditional_statement_sum {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter marks in subject 1");
        int sub1=sc.nextInt();
        System.out.println("Enter marks in subject 2");
        int sub2=sc.nextInt();
        System.out.println("Enter marks in subject 3");
        int sub3=sc.nextInt();
        int avg=(sub1+sub2+sub3)/3;
        if(avg>=40&&sub1>=33&&sub2>=33&&sub3>=33){
            System.out.println("Student is pass");
        }
        else {
            System.out.println("Student is fail");
        }
    }
}
