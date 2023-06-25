package GraphTraversal;

import java.util.Arrays;

public class TSP {

    static final int INF = 999999;

    static int n = 4;
    static int[][] dist = {
            {0, 20, 42, 25},
            {20, 0, 30, 34},
            {42, 30, 0, 10},
            {25, 34, 10, 0}
    };
    static int[][] dp = new int[1 << n][n];
    static int VISITED_ALL = (1 << n) - 1;


    static int tsp(int mask, int pos) {
        if (mask == VISITED_ALL) {
            return dist[pos][0];
        }
        if (dp[mask][pos] != INF) {
            return dp[mask][pos];
        }

        for (int city = 0; city < n; city++) {
            if ((mask & (1 << city)) == 0) {
                int newAns = dist[pos][city] + tsp(mask | (1 << city), city);
                dp[mask][pos] = Math.min(dp[mask][pos], newAns);
            }
        }
        return dp[mask][pos];
    }

    public static void main(String[] args) {
        for (int[] row : dp) {
            Arrays.fill(row, INF);
        }
        System.out.println(tsp(1, 0));
    }
}
