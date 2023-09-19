
 package Hashing;
import java.util.*;

public class MajorityElements {
    public static void majorElem(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        int min = arr.length / 3;

        for (int i = 0; i < arr.length; i++) {
            // if (!map.containsKey(arr[i])) {
            // map.put(arr[i], 1);
            // } else {
            // map.put(arr[i], map.get(arr[i]) + 1);
            // }

            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        Set<Integer> set = map.keySet();
        for (Integer i : set) {
            if (map.get(i) > min) {
                System.out.println(i);
            }
        }

    }

    public static void main(String[] args) {
        // int[] nums = { 1, 3, 2, 5, 1, 3, 1, 5, 1 };
        int nums[] = { 1, 2 };
        majorElem(nums);
    }
}
