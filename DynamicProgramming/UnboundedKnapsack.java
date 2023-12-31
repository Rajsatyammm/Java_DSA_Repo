 package DynamicProgramming;
import java.util.*;
public class UnboundedKnapsack {
    public static int unbKnapsackRec(int[] val, int[] wt, int W, int n) {
        // base case
        if (n == val.length || W == 0) {
            return 0;
        }

        if (wt[n] <= W) { // valid condition
            // include
            int ans1 = val[n] + unbKnapsackRec(val, wt, W - wt[n], n);
            // exclude
            int ans2 = unbKnapsackRec(val, wt, W, n + 1);
            return Math.max(ans1, ans2);

        } else {
            return unbKnapsackRec(val, wt, W, n + 1);
        }
    }

    public static int unbKnapsackMem(int[] val, int[] wt, int W, int i, int[][] dp) {
        if (W == 0 || i == val.length)
            return 0;
        if (dp[i][W] != -1)
            return dp[i][W];
        if (wt[i] <= W) {
            // Include
            int ans1 = val[i] + unbKnapsackMem(val, wt, W - wt[i], i, dp);
            // Exclude
            int ans2 = unbKnapsackMem(val, wt, W, i + 1, dp);
            dp[i][W] = Math.max(ans1, ans2);
            return dp[i][W];
        } else {
            dp[i][W] = unbKnapsackMem(val, wt, W, i + 1, dp);
            return dp[i][W];
        }
    }

    public static int unbKnapsackTab(int[] val, int[] wt, int W) {
        int n = val.length;
        int[][] dp = new int[n + 1][W + 1];
        for (int i = 0; i < dp.length; i++)
            dp[i][0] = 0;
        for (int i = 0; i < dp[0].length; i++)
            dp[0][i] = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= W; j++) {
                int v = val[i - 1];
                int w = wt[i - 1];

                if (w <= j) { // Valid Case
                    // Case 1 : Include
                    int incldProfit = v + dp[i][j - w];
                    // Case 2 : Exclude 
                    int excldProfit = dp[i - 1][j];
                    dp[i][j] = Math.max(incldProfit, excldProfit);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        // for(int[] arr : dp) {
        //     for(int k : arr) {
        //         System.out.print(k + " ");
        //     }
        //     System.out.println();
        // }
        // System.out.println();
        return dp[n][W];

    }
    public static void main(String[] args) {
        int[] val = { 15, 14, 10, 45, 30 };
        int[] wt = { 2, 5, 1, 3, 4 };
        int W = 7;
        int[][] dp = new int[val.length + 1][W+1];
        for(int[] i : dp) {
            Arrays.fill(i, -1);
        }

        // System.out.println(unbKnapsackRec(val, wt, W, 0));
        System.out.println(unbKnapsackMem(val, wt, W, 0, dp));
        // System.out.println(unbKnapsackTab(val, wt, W));
        
    }
}
