package practice_;

import java.util.Random;

public class nQueen {
    private static int print(int[][] chess, String q, int row, String[][]chessB,int count ){
        if(row== chess.length){
            count++;
            System.out.println("Solution number: "+count);
            System.out.println(q);
            for (int i=0;i< chess.length;i++) {
                for (int j = 0; j < chess[0].length; j++)
                    System.out.print(chessB[i][j]+"\t");
                System.out.println();
            }
            System.out.println();
            return count;
        }

        for (int col=0; col <chess.length; col++){
            if(queenSafe(chess,row,col)){
                chess[row][col] = 1;
                chessB[row][col]="Q";
                count=print(chess, q + (row+1) + "-" + (col+1) + ", ", row + 1,chessB,count);
                chess[row][col] = 0;
                chessB[row][col]=".";
            }
        }
        return count;
    }
    private static boolean queenSafe(int[][] chess, int row, int col){
        for (int i = row-1;i>=0;i--)if(chess[i][col]==1)return false;
        for (int i = row-1, j=col-1;i>=0&&j>=0;i--,j--)if(chess[i][j]==1)return false;
        for (int i = row-1,j=col+1;i>=0&&j<chess.length;i--,j++)if(chess[i][j]==1)return false;
        return true;
    }
    public static void main(String[] args) {
        Random random = new Random();
        int n = random.nextInt(0,11);
        int count;
        String[][] chessB= new String[n][n];
        for (int i=0;i<n;i++)
            for (int j = 0; j<n;j++)
                chessB[i][j]=".";
        int[][] chess = new int[n][n];
        count=print(chess,"",0,chessB,0);
        System.out.println("The total number of solutions is "+count+" for "+n+"x"+n+" chessboard");

    }
}
