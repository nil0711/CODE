package practice;

import java.util.Random;
public class Nqueen {
    private static void print(int[][] chess, String qsf, int row, String[][] answer){
        if (row== chess.length){
            System.out.println(qsf);
            for (int i = 0; i<answer.length; i++) {
                for (int j = 0; j < answer[0].length; j++) {
                    System.out.print(answer[i][j]+"\t");
                }
                System.out.println();
            }
            return ;
        }
        for (int col = 0 ; col< chess.length; col++){
            if(queenSafe(chess,row,col)) {
                answer[row][col]="Q";
                chess[row][col] = 1;
                print(chess, qsf + row + "-" + col + ", ", row + 1,answer);
                answer[row][col]=".";
                chess[row][col] = 0;
            }

        }

    }
    public static boolean queenSafe(int[][] chess, int row, int col){
        for (int i = row-1; i>=0; i--) if (chess[i][col]==1) return false;
        for (int i = row-1, j = col-1;i>=0&&j>=0;i--,j--) if (chess[i][j]==1) return false;
        for (int i = row-1, j = col+1;i>=0&&j<chess.length;i--,j++) if (chess[i][j]==1) return false;

        return true;
    }

    public static void main(String[] args) {
        Random random = new Random();

        int n = 2;

        String[][] answer = new String[n][n];
        for (int i = 0; i<answer.length; i++)
            for (int j=0; j<answer[0].length;j++)
                answer[i][j]=".";

        int[][] chess = new int[n][n];
        print(chess,"",0,answer);

    }
}
