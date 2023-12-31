 package Practice;
import java.util.Scanner;

public class PascalTriangle {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int i, j, k, rows, count;
        System.out.println("Enter the height");
        rows = s.nextInt();
        count = rows - 1;
        for (i = 0; i < rows; i++) {
            int a = 1;
            for (j = 0; j <= count; j++) {
                System.out.print(" "); // printing spaces here
            }
            for (k = 0; k <= i; k++) {
                System.out.print(a + " "); // Printing the numbers of the triangle
                a = (a * (i - k) / (k + 1)); // Formula for pascal triangle
            }
            count--;
            System.out.println();// Printing next line
        }
    }
}