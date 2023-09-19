 package Hashing;
import java.util.*;
public class SubarraywithSumZero {

    public static int calLengthOfSubarray(int[] arr) {
        Map<Integer, Integer> hm = new HashMap<>();
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> al = new ArrayList<>();

        int currSum = 0;
        int maxLength = 0;

        for(int j=0; j<arr.length; j++) {
            currSum += arr[j];
            if(hm.containsKey(currSum)) {
                maxLength = Math.max(maxLength, j - hm.get(currSum));

            } else {
                hm.put(currSum, j);
            }
        }    
        return maxLength;
    }
    public static void main(String[] args) {
        int[] arr = {15, -2, 2, -8, 1, 7, 10, 23};
        int length = calLengthOfSubarray(arr);
        System.out.println(length);
    }
}
