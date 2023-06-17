import java.util.*;
class game {
    static Random ran=new Random();
    private int a;
    private static int b=random_number();

    public static int random_number(){
        int number= ran.nextInt();
        if(number<0){number=-number;}
        return number%100;
    }
    public void user_input(){
        Scanner sc=new Scanner(System.in);
        a= sc.nextInt();
    }
    public boolean isCorrectNumber(){
//        System.out.println(a+" "+b);
//        System.out.println(a==b);
        return a == b;
    }
    public void seta(int a) {
        this.a = a;
    }


    public void game_start() {
            do{
                if (isCorrectNumber()) {
                    System.out.println("You win");break;
                } else if (a < b) {
                    System.out.println("Low number. Keep trying");
                    user_input();
                } else {
                    System.out.println("High number. Keep trying");
                    user_input();
                }

            }while (true);
    }

}
public class guess_the_numbeer_game {
    public static void main(String[] args) {
        Random ran=new Random();
        Scanner sc=new Scanner(System.in);
        game g=new game();
        System.out.println("This is a number guessing game.The computer has randomly generated a number between 0~99. Enter number to start playing");
        int test = sc.nextInt();
        g.seta(test);
        g.game_start();
    }
}
