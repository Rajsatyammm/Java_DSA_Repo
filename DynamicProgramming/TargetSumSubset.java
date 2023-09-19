package DynamicProgramming;

import java.util.*;

class TargetSumSubset {

    private static boolean targetSum(int[] num, int target) {
        int N = num.length;
        boolean dp[][] = new boolean[N + 1][target + 1];
        for (int i = 1; i < dp[0].length; i++)
            dp[0][i] = false;
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= target; j++) {
                int v = num[i - 1];
                // valid case with included condition
                if (v <= j && dp[i - 1][j - v] == true)
                    dp[i][j] = true;
                // invalid case && valid case with excluded condition
                if (dp[i - 1][j] == true)
                    dp[i][j] = true;
            }
        }

//        for (boolean[] b : dp) {
//            for (boolean bb : b) {
//                System.out.print(bb + " ");
//            }
//            System.out.println();
//        }
        return dp[N][target];
    }

    public static void main(String[] args) {
        int num[] = { 4, 2, 7, 1, 3 };
        int target = 10;
        System.out.println(targetSum(num, target));
    }
}