package practice;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class knapsack {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        Random random = new Random();

        System.out.println("Enter number of products : ");
        int n = 5;
        int[] val = new int[n];
        int[] weight = new int[n];

        System.out.println("Enter value of products : ");
        for (int i= 0; i < val.length; i++){
            val[i]= random.nextInt(0,40);
        }
        System.out.println(Arrays.toString(val));

        System.out.println("Enter weight of products : ");
        for (int i= 0; i < weight.length; i++){
            weight[i]= random.nextInt(1,10);
        }
        System.out.println(Arrays.toString(weight));

        System.out.println("Enter capacity : ");
        int cap = 10;


        int[][] dp= new int[n+1][cap+1];
        for (int i =0 ; i< n+1; i++){
            for (int j = 0 ; j < cap+1; j++){
                dp[i][j]=0;
            }
        }
        for (int i =1 ; i< n+1; i++){
            for (int j = 1 ; j < cap+1; j++){
                if(j>=weight[i-1]){
                    int rCap= j-weight[i-1];
                    if(dp[i-1][rCap]+val[i-1]>dp[i-1][j]){
                        dp[i][j]=dp[i-1][rCap]+val[i-1];
                    }
                    else dp[i][j]=dp[i-1][j]; //when i isn't included
                }
                else dp[i][j]=dp[i-1][j]; //when i isn't included
            }
        }
        for (int i =1 ; i< n+1; i++){
            for (int j = 1 ; j < cap+1; j++){
                System.out.print(dp[i][j]+"\t");
            }
            System.out.println();
        }

    }
}
