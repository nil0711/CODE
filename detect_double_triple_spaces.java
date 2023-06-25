import java.util.Scanner;
public class detect_double_triple_spaces {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String test = "dh gi ty sd,hi ui";
        System.out.println(test.indexOf("  "));
        System.out.println((test.indexOf("   ")));

    }
}
