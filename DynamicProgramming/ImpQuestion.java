package DynamicProgramming;
import java.util.*;
public class ImpQuestion {
    static class Question {
        // Frog Jump either 1 step or 2 step
        public int frogJumpWays(int[] cost, int i) {
            if(i == 0) return 0;
            int left = frogJumpWays(cost, i-1) + Math.abs(cost[i] - cost[i-1]);
            int right = Integer.MAX_VALUE;
            if(i > 1)
                right = frogJumpWays(cost, i-2) + Math.abs(cost[i] - cost[i-2]);
            return Math.min(left, right);
        }

        // frog can jump upto k steps
        public int frogJumpKsteps(int[] cost, int k, int i) {
            if(i == 0) return 0;
            int min = Integer.MAX_VALUE;
            for(int j=i; j<=k; j++) {
                if(i - j > 0) {
                    int currMin = frogJumpKsteps(cost, k, i - 1) + Math.abs(cost[i] + cost[i - j]);
                    min = Math.min(min, currMin);
                }
            }
            return min;
        }

        // maximum non adjacent sum
        public int maxNonAdjSumTab(int[] arr) {
            int n = arr.length;
            int prev = arr[0];
            int prev2 = 0;

            for(int i=1; i<n; i++) {
//                dp[i] = Math.max(dp[i-2] + arr[i-1], dp[i-1]);
                int ans1 = prev2 + arr[i];
                int ans2 = arr[i-1];
                int curr = Math.max(ans1, ans2);
                prev2 = prev;
                prev = curr;
            }
            return prev;
        }

        public int maxNonAdjSumRec(int[] arr, int i) {
            if(i == 0) return arr[i];
            int ans1 = maxNonAdjSumRec(arr, i-1);
            int ans2 = Integer.MIN_VALUE;
            if(i > 1) ans2 = maxNonAdjSumRec(arr, i-2) + arr[i];
            return Math.max(ans1, ans2);
        }

    }
    public static void main(String[] args) {
        Question q = new Question();
//        int[] cost = {10, 20, 30, 10};
        int[] cost = {7, 4, 4, 2, 6, 6, 3, 4};
//        System.out.println(q.frogJumpWays(cost, cost.length - 1));
        int[] arr = {22, 6, 1, 5};

        System.out.println(q.maxNonAdjSumTab(arr));
        System.out.println(q.maxNonAdjSumRec(arr, arr.length-1));
    }

}
