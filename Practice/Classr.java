 package Practice;

public class Classr {
    public static void main(String[] args) {
        char[] arr = { 'r', 'g', 'b', 'b', 'r', 'g', 'y', 'y', 'b' };
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    count++;
                }
            }
            if (count % 2 != 0) {
                System.out.println(arr[i]);
                break;
            }
        }
    }
}
