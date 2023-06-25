import java.util.Scanner;
public class strings_sum {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        String default_="Dear <|name|>,Thanks a lot";
        String default_1=default_.substring(0,5);
        String default_2=default_.substring(13);
        System.out.println("Enter your name");
        String input_=sc.nextLine();
        System.out.print(default_1);
        System.out.print(input_);
        System.out.print(default_2);

    }
}
