
 package Hashing;
import java.util.*;

public class SubarrayWithSumK {
    public static void main(String[] args) {
        int[] arr = { 10, 2, -2, -20, 10 };
        int k = -10;

        Map<Integer, Integer> hm = new HashMap<>();
        hm.put(0, 1);

        int currSum = 0;
        int res = 0;
        for (int j = 0; j < arr.length; j++) {
            currSum += arr[j];
            if (hm.containsKey(currSum - k)) { 
                res += hm.get(currSum - k);
            }
            hm.put(currSum, hm.getOrDefault(currSum, 0) + 1);
        }

        System.out.println(res);
    }
}
