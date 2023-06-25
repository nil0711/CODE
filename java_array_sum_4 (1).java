import java.util.*;
public class java_array_sum_4 {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] matrix_1 = new int[2][3];
        int[][] matrix_2 = new int[2][3];
        int[][] matrix_sum = new int[2][3];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.println("Enter element a[" + i + "][" + j + "]");
                matrix_1[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.println("Enter element a[" + i + "][" + j + "]");
                matrix_2[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                matrix_sum[i][j] = matrix_1[i][j] + matrix_2[i][j];
            }
        }
        //System.out.println(matrix_sum);
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++){
                System.out.print(matrix_sum[i][j]+"\t");
            }
            System.out.printf("\n");
    }}}