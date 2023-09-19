package Recursion;

public class PatternUsingRecursion {

    static void triangle(int r, int c) {
        if(r == 0) return;
        if(c < r) {
            System.out.print("* ");
            triangle(r, c+1);
        }
        else {
            System.out.println();
            triangle(r-1, 0);
        }
    }

    static void bubbleSortRec(int[] arr, int n, int i) {
        if(i == arr.length-1) return;
        for(int pass = 0; pass<arr.length-1; pass++) {
            if(arr[i] > arr[i+1]) {
                int temp = arr[i];
                arr[i] = arr[i+1];
                arr[i+1] = temp;
                bubbleSortRec(arr, n,i+1);
            }
            bubbleSortRec(arr, n-pass, 0);
        }

    }

    public static void main(StringRecursion[] args) {
//        triangle(4, 0);
        int[] arr = {6, 4, 2, 9, 1, 7};
        bubbleSortRec(arr, arr.length, 0);
        for(int i : arr) {
            System.out.print(i + " ");
        }
    }
}
