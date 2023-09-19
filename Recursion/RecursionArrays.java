package Recursion;
class RecursionArray {
    public boolean reverse(int[] arr, int i) {
        if(i == arr.length - 1) return true;
        if(arr[i] > arr[i+1]) return false;
        return reverse(arr, i+1);
    }

    public int linearSearch(int[] arr, int target, int idx) {
        if(idx == arr.length) return -1;
        if(arr[idx] == target) return idx;
        return linearSearch(arr, target, idx+1);
    }
}

public class RecursionArrays {

    public static void main(StringRecursion[] args) {
         int arr[] = {1, 4, 11, 8, 9};
         RecursionArray r = new RecursionArray();
//        System.out.println(r.reverse(arr, 0));
        System.out.println(r.linearSearch(arr, 1111, 0));
    }
}
