package Patterns;
import java.util.Scanner;
public class Classroom {

     public static void printPattern() {
     // * * * *
     // *     *
     // *     *
     // * * * *
     for (int i = 0; i < 4; i++) {
     for (int j = 0; j < 4; j++) {
     if (i == 0 || j == 0 || i == 3 || j == 3) {
     System.out.print("* ");
     } else {
     System.out.print("  ");
     }
     }
     System.out.println();
     }
     }

    // public static void printPattern() {
    // // *
    // // * *
    // // * * *
    // // * * * *
    // for (int i = 0; i < 4; i++) {
    // for (int j = 0; j <= i; j++) {
    // System.out.print("* ");
    // }
    // System.out.println();
    // }

    // }

    // public static void printPattern() {
    //     // * * * *
    //     // * * *
    //     // * *
    //     // *

    //     for (int i = 0; i < 4; i++) {
    //         for (int j = 4; j > i; j--) {
    //             System.out.print("* ");
    //         }
    //         System.out.println();
    //     }
    // }

    // public static void printPattern() {
    //     //        *
    //     //      * *
    //     //    * * *
    //     //  * * * *

    //     for (int i = 1; i <= 4; i++) {
    //         for (int j = 1; j <= 4-i; j++) {
    //             System.out.print("  ");
    //         }
    //         for(int j = 1; j <= i; j++) {
    //             System.out.print("* ");
    //         }
    //         System.out.println();
    //     }
    // }

    // public static void printPattern() {
    //     // 1
    //     // 1 2
    //     // 1 2 3
    //     // 1 2 3 4
    //     // 1 2 3 4 5
    //     for(int i = 1; i <= 5; i++) {
    //         for(int j = 1; j <= i; j++) {
    //             System.out.print(j+" ");
    //         }
    //         System.out.println();
    //     }
    // }

    // public static void printPattern() {
    //     // 1 2 3 4 5
    //     // 1 2 3 4 
    //     // 1 2 3 
    //     // 1 2 
    //     // 1

    //     for(int i = 1; i <= 5; i++) {
    //         for(int j = 1; j <= 5 - i + 1; j++) {
    //             System.out.print(j+" ");
    //         }
    //         System.out.println();
    //     }
    // }

    // public static void printPattern() {
    //     // 1
    //     // 2  3
    //     // 4  5  6
    //     // 7  8  9  10
    //     // 11 12 13 14 15

    //     int count = 1;
    //     for(int i =1; i <= 5; i++) {
    //         for(int j = 1; j <= i; j++) {
    //             System.out.print(count + " ");
    //             count++;
    //         }
    //         System.out.println();
    //     }
    // }

    // public static void printPattern() {
    //     // 1
    //     // 0 1
    //     // 1 0 1
    //     // 0 1 0 1
    //     // 1 0 1 0 1
        
    //     for(int i=1; i<=5; i++) {
    //         for(int j=1; j<= i; j++) {
    //             if((i+j) % 2 == 0) {
    //                 System.out.print("1 ");
    //             } else {
    //                 System.out.print("0 ");
    //             }
    //         }
    //         System.out.println();
    //     }   
    // }

    // public static void printPattern() {
    //     // A 
    //     // B C 
    //     // D E F 
    //     // G H I J 
    //     // K L M N O 

    //     char count = 'A';
    //     for(int i =1; i <= 5; i++) {
    //         for(int j = 1; j <= i; j++) {
    //             System.out.print(count + " ");
    //             count++;
    //         }
    //         System.out.println();
    //     }
    // }

    // public static void printPattern() {
    //     // ButterFly Pattern
    //     // *             *
    //     // * *         * *
    //     // * * *     * * *
    //     // * * * * * * * *
    //     // * * * * * * * * 
    //     // * * *     * * *
    //     // * *         * * 
    //     // *             *

    //     for(int i = 1; i <= 4; i++) {
    //         for(int j=1; j<= i; j++) {
    //             System.out.print("* ");
    //         }
    //         for(int j = 1; j<= 2*(4-i); j++) {
    //             System.out.print("  ");
    //         }
    //         for(int j=1; j<= i; j++) {
    //             System.out.print("* ");
    //         }
    //         System.out.println();
    //     }
    //     for(int i = 4; i >= 1; i--) {
    //         for(int j=1; j<= i; j++) {
    //             System.out.print("* ");
    //         }
    //         for(int j = 1; j<= 2*(4-i); j++) {
    //             System.out.print("  ");
    //         }
    //         for(int j=1; j<= i; j++) {
    //             System.out.print("* ");
    //         }
    //         System.out.println();
    //     }
    // }

    // public static void printPattern() {
    //     for(int i =1; i<= 5; i++) {
    //         for(int j=4; j>=i; j--) {
    //             System.out.print("  ");
    //         }
    //         for(int j = 1; j<=5; j++) {
    //             System.out.print("* ");
    //         }
    //         System.out.println();
    //     }
    // }

    // public static void printPattern() {

    //     //         1
    //     //       2 1 2
    //     //     3 2 1 2 3 
    //     //   4 3 2 1 2 3 4
    //     // 5 4 3 2 1 2 3 4 5 

    //     for(int i = 1; i<= 5; i++) {
    //         for(int j=1; j <= 5-i; j++) {
    //             System.out.print("  ");
    //         }
    //         for(int j=i; j>0; j--) {
    //             System.out.print(j+" ");
    //         }
    //         for(int j=2; j<=i; j++) {
    //             System.out.print(j+" ");
    //         }
    //         System.out.println();
    //     }
    // }


    public static void main(String[] args) {

        printPattern();
    }
}
  