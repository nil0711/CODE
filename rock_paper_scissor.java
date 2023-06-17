import java.util.*;
public class rock_paper_scissor {
    public static void main(String[] args) {
        Random ran=new Random();
        Scanner sc=new Scanner(System.in);
        do{
            int number= ran.nextInt();
//            System.out.println(number);
            if(number<0){number=0-number;}
            int comp=number%3;
//            System.out.println(comp);
            System.out.println("Enter 0 for Rock, 1 for Paper, 2 for scissor, or any other number to exit");
            int user=sc.nextInt();
            if (user!=0&&user!=1&&user!=2){break;}
            if(comp==user){
                System.out.println("It is a tie. Try again");
            }
            else if ((comp==0&&user==1)||(comp==1&&user==2)||(comp==2&&user==0)) {
                System.out.println("You win!");
            }
            else {
                System.out.println("You Lose. Better luck next time.");
            }

        }while (true);
        System.out.println("Thank you for playing!");

    }
}
