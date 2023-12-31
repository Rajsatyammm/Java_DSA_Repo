package Practice;

import java.util.*;

public class PascalTriangleMemoisation {

    public static void printSpaces(int rows) {
        if (rows == 0) {
            return;
        }
        System.out.print(" ");
        printSpaces(--rows);
    }

    public static int values(int n, int k) {
        String key = n + "," + k;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        if (k == 0 || k == n) {
            memo.put(key, 1);
            return 1;
        } else {
            int result = values(n - 1, k - 1) + values(n - 1, k);
            memo.put(key, result);
            return result;
        }
    }

    static Map<String, Integer> memo = new HashMap<>();

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the height of the triangle");
        int rows = s.nextInt();

        for (int i = 0; i < rows; i++) {
            printSpaces(rows - i);
            for (int j = 0; j <= i; j++) {
                System.out.print(values(i, j) + " ");
            }
            System.out.println();
        }
    }
}