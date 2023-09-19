package Recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class Subset {
    public static void main(String[] args) {
        int[] arr = {1, 2, 2};
        System.out.println(subsetDuplicate(arr));
    }

    public static List<List<Integer>> subset(int[] arr) {

        List<List<Integer>> res = new ArrayList<>();

        res.add(new ArrayList<>());

        for(int num : arr) {
            int n = res.size();
            for(int i=0; i<n; i++) {
                List<Integer> al = new ArrayList<>(res.get(i));
                al.add(num);
                res.add(al);
            }
        }
        return res;
    }

    public static List<List<Integer>> subsetDuplicate(int[] arr) {

        Arrays.sort(arr);
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        int start = 0, end = 0;
        for(int i=0; i<arr.length; i++) {
            start = 0;

            if(i > 0 && arr[i] == arr[i-1]) {
                start = end + 1;
            }
            end = res.size() - 1;

            int n = res.size();
            for(int j=start; j<n; j++) {
                List<Integer> al = new ArrayList<>(res.get(j));
                al.add(arr[i]);
                res.add(al);
            }
        }
        return res;
    }
}
