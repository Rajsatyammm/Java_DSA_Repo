import java.util.Scanner;

class reverse {
  void swap(int i, int j) {
    int temp = i;
    i = j;
    j = temp;
  }

  void ArrReverse(int[] A) {
    int size = A.length;
    for (int i = 0; i < (size / 2); i++) {
      swap(A[i], A[size - i - 1]);
    }

    // for (int i : A) {
    //   System.out.println(i);
    // }
    for (int i = 0; i < A.length; i++) {
        System.out.println(A[i]);
    }
  }
}

public class ArrayReverse {

  public static void main(String[] args) {
    int[] A;
    reverse R = new reverse();
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the size of Array");
    int s = sc.nextInt();
    A = new int[s];
    System.out.println("Enter Array Elements : ");
    for (int i = 0; i < s; i++) {
      A[i] = sc.nextInt();
    }

    System.out.println("After Reverse : ");
    R.ArrReverse(A);
    // for (int i : A) {
    //     System.out.println(i);
    // }
  }
}
