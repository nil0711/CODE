package practice_;
import java.util.Arrays;
import java.util.Random;

public class knapsack {
    public static void main(String[] args) {
        Random random= new Random();

        System.out.println("Enter number of products: ");
        int n = random.nextInt(1,10);
        System.out.println(n);
        System.out.println("Enter value of the products: ");
        int[] val= new int[n];
        for (int i=0 ; i< n; i++)val[i]=random.nextInt(1,10);
        System.out.println(Arrays.toString(val));

        System.out.println("Enter the weight of the products");
        int[] wts= new int[n];
        for (int i = 0; i<n;i++)wts[i]= random.nextInt(1,10);
        System.out.println(Arrays.toString(wts));

        System.out.println("Enter capacity of the knapsack: ");
        int cap = random.nextInt(10,15);
        System.out.println(cap);

        int[][] dp = new int[n+1][cap+1];

        for (int i = 0; i< dp.length;i++)
            for (int j = 0; j<dp[0].length;j++)
                dp[i][j]=0;


        for (int i = 1; i< dp.length;i++)
            for (int j = 1; j<dp[0].length;j++){
                if(j>=wts[i-1]){
                    int rcap = j-wts[i-1];
                    dp[i][j] = Math.max(dp[i - 1][rcap] + val[i - 1], dp[i - 1][j]);
                }
                else dp[i][j]=dp[i-1][j];
            }

        System.out.println("The knapsack is :");

        for (int i = 0; i < dp.length; i++) {
                for (int j = 0; j < dp[0].length; j++){
                    if(i==0&&j==0){
                        System.out.print("X"+"|\t");
                        continue;
                    }
                    if (i == 0){
                        System.out.print(j+"\t");
                        continue;
                    }
                    if(j == 0){
                        System.out.print(val[i-1]+"|\t");
                        continue;
                    }

                    System.out.print(dp[i][j] + "\t");
                }

            System.out.println();
            for (int k = 0; k<=cap;k++) System.out.print("----");
            System.out.println();
            }
        System.out.println("The max value in the kanpsack is "+ dp[n][cap]);

    }
}
