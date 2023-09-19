package DynamicProgramming;
import java.util.*;
public class WildcardMatching {
    public static boolean matchingCardTab(String text, String pattern) {
        int N = text.length();
        int M = pattern.length();
        boolean[][] dp = new boolean[N+1][M+1];
        dp[0][0] = true;
        for(int i=1; i<N; i++) {
            dp[i][0] = false;
        }
        for(int j=1; j<M; j++) {
            if(pattern.charAt(j-1) == '*') dp[0][j] = dp[0][j-1];
            else dp[0][j] = false;
        }

        for(int i=1; i<=N; i++) {
            for (int j = 1; j <= M; j++) {
                if (text.charAt(i - 1) == pattern.charAt(j - 1) || pattern.charAt(j - 1) == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (pattern.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                } else {
                    dp[i][j] = false;
                }
            }
        }
        return dp[N][M];
    }
    public static void main(String[] args) {
//        String text = "baaabab";
        String text = "nvjfdjofqjvdfadfajgjal";
//        String pattern = "*****ba*****ab";
//        String pattern = "bcd****?ab";
        String pattern = "*";
//        int N = text.length();
//        int M = pattern.length();
        System.out.println(matchingCardTab(text, pattern));
    }
}
