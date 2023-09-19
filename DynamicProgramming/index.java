package DynamicProgramming;
import java.util.*;

public class index {

    private static int knapsack01Rec(int[] val, int[] wt, int W, int idx) {

        //base case
        if(idx == val.length || W == 0) return 0;
        if(wt[idx] <= W) { //valid
            return Math.max(val[idx] + knapsack01Rec(val, wt, W-wt[idx], idx+1), knapsack01Rec(val, wt, W, idx+1));
        }
        else {
            return knapsack01Rec(val, wt, W, idx+1);
        }
    }

    private static int knapsack01Mem(int[] val, int[] wt, int W, int idx, int[][] dp) {
        if(idx == val.length || W == 0) return 0;

        if(dp[idx][W] != -1) return dp[idx][W];

        if(wt[idx] <= W) {
            dp[idx][W] = Math.max(val[idx] + knapsack01Mem(val, wt, W-wt[idx], idx+1, dp),
                    knapsack01Mem(val, wt, W, idx+1, dp));
        }
        else{
            dp[idx][W] = knapsack01Mem(val, wt, W, idx+1, dp);
        }
        return dp[idx][W];
    }

    private static int knapsack01Tab(int[] val, int[] wt, int W) {
        int n = val.length;
        int[][] dp = new int[n+1][W+1];
        //initialization
        for(int i=0; i<n; i++) dp[i][0] = 0;
        for(int j=0; j<W; j++) dp[0][j] = 0;

        for(int i=1; i<=n; i++) {
            for(int j=1; j<=W; j++) {
                int v = val[i-1];
                int w = wt[i-1];
                if(w <= j) {
                    dp[i][j] = Math.max(v + dp[i-1][j-w], dp[i-1][j]);
                }
                else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][W];
    }

    private static int rodCuttingRec(int[] len, int[] price, int rodLen, int i) {
        if(rodLen == 0 || i == len.length) return 0;
        if(len[i] <= rodLen) {
            return Math.max(price[i] + rodCuttingRec(len, price, rodLen-len[i], i),
                    rodCuttingRec(len, price, rodLen, i+1));
        }
        else {
            return rodCuttingRec(len, price, rodLen, i+1);
        }
    }

    private static int rodCuttingMem(int[] len, int[] price, int rodLen, int i, int[][] dp) {
        if(rodLen == 0 || i == len.length) return 0;
        if(dp[i][rodLen] != -1) return dp[i][rodLen];

        if(len[i] <= rodLen) {
            dp[i][rodLen] = Math.max(price[i] + rodCuttingMem(len, price, rodLen-len[i], i, dp),
                    rodCuttingMem(len, price, rodLen, i+1, dp));
        }
        else{
            dp[i][rodLen] = rodCuttingMem(len, price, rodLen, i+1, dp);
        }
        return dp[i][rodLen];
    }
    private static int rodCuttingTab(int[] len, int[] price, int rodLen) {
        int[][] dp = new int[len.length + 1][rodLen + 1];
        // init
        for(int i=0; i<len.length; i++) dp[i][0] = 0;
        for(int j=0; j<rodLen; j++) dp[0][j] = 0;

        for(int i=1; i<=len.length; i++) {
            for(int j=1; j<=rodLen; j++) {
                int p = price[i-1];
                int l = len[i-1];
                if(l <= j) dp[i][j] = Math.max(p + dp[i][j-l], dp[i-1][j]);
                else dp[i][j] = dp[i-1][j];
            }
        }
        return dp[len.length][rodLen];
    }

    private static int lcsRec(String str1, String str2, int i, int j) {
        if(i == 0 || j == 0) return 0;
        if(str1.charAt(i-1) == str2.charAt(j-1)) {
            return lcsRec(str1, str2, i-1, j-1)  + 1;
        }
        else {
            int f = lcsRec(str1, str2, i, j-1);
            int s = lcsRec(str1, str2, i-1, j);
            return Math.max(f, s);
        }
    }

    private static int lcsMem(String str1, String str2, int i, int j, int[][] dp) {
        if(i == 0 || j == 0) return 0;
        if(dp[i][j] != -1) return dp[i][j];

        if(str1.charAt(i-1) == str2.charAt(j-1)) {
            dp[i][j] = lcsMem(str1, str2, i-1, j-1, dp) + 1;
        }
        else {
            dp[i][j] = Math.max(lcsMem(str1, str2, i-1, j, dp), lcsMem(str1, str2, i, j-1, dp));
        }
        return dp[i][j];
    }

    private static int lcsTab(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        int[][] dp = new int[n+1][m+1];

        //init
        for(int i=0; i<n; i++) dp[i][0] = 0;
        for(int j=0; j<m; j++) dp[0][j] = 0;

        //
        for(int i=1; i<=n; i++) {
            for(int j=1; j<=m; j++) {
                if(str1.charAt(i-1) == str2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                }
                else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[n][m];
    }

    private static int lcSubRec(String str1, String str2, int i, int j) {
        int maxLen = 0;
        if(i == 0 || j == 0) return 0;
        if(str1.charAt(i-1) == str2.charAt(j-1)) {
            int s =  lcSubRec(str1, str2, i-1, j-1) + 1;
            maxLen = Math.max(maxLen, s);
            return s;
        }
        else {
            return 0;
        }
    }

    private static int editDistanceRec(String str1, String str2, int i, int j) {
        if(i == str1.length() || j == str2.length()) return 0;
        if(str1.charAt(i-1) == str2.charAt(j-1)) {
            return editDistanceRec(str1, str2, i-1, j-1);
        }
        else {
            int f = editDistanceRec(str1, str2, i-1, j); // remove a char
            int s = editDistanceRec(str1, str2, i-1, j-1); // update a char
            int t = editDistanceRec(str1, str2, i, j-1);
            return Math.min(f, Math.min(s, t));
        }
    }

    public static void main(String[] args) {
        int[] val = {15, 14, 10, 45, 30};
        int[] wt = {2, 5, 1, 3, 4};

//        int[][] dp = new int[val.length + 1][wt.length + 1];
//        for(int[] arr : dp)
//            Arrays.fill(arr, -1);
//        System.out.println(knapsack01Rec(val, wt, 7, 0));
//        System.out.println(knapsack01Mem(val, wt, 7, 0, dp));
//        System.out.println(knapsack01Tab(val, wt, 7));

        int[] len = {1, 2, 3, 4, 5, 6, 7, 8};
        int[] price = {1, 5, 8, 9, 10, 17, 17, 20};
        int rodLen = 8;

//        int[][] dp = new int[len.length + 1][rodLen + 1];
//        for(int[] arr : dp) Arrays.fill(arr, -1);

//        System.out.println(rodCuttingRec(len, price, rodLen,0));
//        System.out.println(rodCuttingMem(len, price, rodLen, 0, dp));
//        System.out.println(rodCuttingTab(len, price, rodLen));

//        String str1 = "abcdge", str2 = "abedg";


//        int[][] dp = new int[str1.length() + 1][str2.length() + 1];
//        for(int[] arr : dp) Arrays.fill(arr, -1);
//
//        System.out.println(lcsRec(str1, str2, str1.length(), str2.length()));
//        System.out.println(lcsMem(str1, str2, str1.length(), str2.length(), dp));
//        System.out.println(lcsTab(str1, str2));


//        String s1 = "abcde", s2 = "abgce";
//        String s1 = "abcdgh", s2 = "acdghr";
//        lcSubRec(s1, s2, s1.length(), s2.length());



    }
}
