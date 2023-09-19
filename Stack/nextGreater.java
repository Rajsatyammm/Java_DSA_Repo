package Stack;

import java.util.Stack;
public class nextGreater {

    public static void nextGreater(int[] arr, int[] nextG) {
        Stack<Integer> s = new Stack<>();
        int n = arr.length;
        nextG[n - 1] = -1;
        s.push(arr[n - 1]);
        // System.out.println(s.peek());
        for (int i = n - 2; i >= 0; i--) {
            int curr = arr[i];
            while (!s.isEmpty() && curr >= s.peek()) {
                s.pop();
            }
            if (s.isEmpty()) {
                nextG[i] = -1;
            } else {
                nextG[i] = s.peek();
            }
            s.push(arr[i]);
        }
    }

    public static void print(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args) {

        int[] arr = { 6, 8, 0, 1, 3 };
        int[] nextG = new int[arr.length];

        nextGreater(arr, nextG);
        print(nextG);

    }
}
