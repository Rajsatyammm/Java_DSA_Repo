import java.util.Scanner;

public class PascalTriangleRecursion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("No of rows: ");
        int rows = sc.nextInt();

        for (int i = 0; i < rows; i++) {
            printSpaces(rows - i);
            for (int j = 0; j <= i; j++) {
                System.out.print(value(i, j) + " ");
            }
            System.out.println();
        }
    }

    // The following method print spaces
    public static void printSpaces(int rows) {
        if (rows == 0) {
            return;
        }
        System.out.print(" ");
        printSpaces(rows - 1);
    }

    // The following method gives the value
    public static int value(int row, int col) {
        if (col == 0 || col == row) {
            return 1;
        } else {
            return value(row - 1, col - 1) + value(row - 1, col);
        }
    }
}