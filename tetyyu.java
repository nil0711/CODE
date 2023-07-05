import java.util.Scanner;

public class tetyyu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[][] mat = new String[3][3];


        for(int i  =0 ; i< 3;i++){
            for(int j = 0 ; j< 3; j++){
                mat[i][j] = sc.nextLine();
            }
        }

        System.out.println("Enter the finding value");
        val = sc.nextLine();
        for(int i  =0 ; i< 3;i++){
            for(int j = 0 ; j< 3; j++){
                if(mat[i][j].contains(val)){
                    System.out.println();
                }
            }
        }

    }
}
