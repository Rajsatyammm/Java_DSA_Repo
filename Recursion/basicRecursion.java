 package Recursion;

 public class basicRecursion {
    public static void printNum(int n) {
        if (n == 1) {
            System.out.print(n + " ");
            return;
        }
        printNum(n - 1);
        System.out.print(n + " ");
    }

    public static int factorial(int n) {
        if (n == 0) {
            return 1;
        }
        return (n * factorial(n - 1));

    }

    public static int sumofNatural(int n) {
        if (n == 1) {
            return 1;
        }
        return (n + sumofNatural(n - 1));
    }

    public static int fabbonacci(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        return (fabbonacci(n - 1) + fabbonacci(n - 2));
    }

    public static boolean isSorted(int[] arr, int i) {
        if (i == arr.length - 1) {
            return true;
        }
        if (arr[i] > arr[i + 1]) {
            return false;
        }
        return isSorted(arr, i + 1);
    }

    public static int firstOccurance(int[] arr, int key, int i) {
        if (i == arr.length) {
            return -1;
        }
        if (arr[i] == key) {
            return i;
        }
        return firstOccurance(arr, key, i + 1);
    }

    public static int lastOccurance(int[] arr, int key, int i) {
        if (i == arr.length) {
            return -1;
        }
        int isFound = lastOccurance(arr, key, i + 1);
        if (isFound == -1 && arr[i] == key) {
            return i;
        } else {
            return isFound;
        }
    }

    public static int calculatePower(int base, int power) {
        if (power == 1) {
            return base;
        }
        return base * (int) Math.pow((double) base, (double) power - 1);
    }

    public static int calcPower(int base, int power) { //T(n) = O(n)
        if(power == 1) {
            return base;
        }
        int halfPower = calcPower(base, power/2);
        int half = halfPower * halfPower;
        if(power % 2 != 0) {
            return base * calcPower(base, power/2);
        }
        return half;
    }

    public static int optimizedPower(int a, int n) {
        if(n == 0) return 1;
        int half = optimizedPower(a, n/2);
        int halfPowSq = half * half;
        if(n % 2 != 0) halfPowSq *= a;
        return halfPowSq;
    }

    public static int sumOfNNumber(int N, int sum) {
        if(N < 1) return sum;
        return sumOfNNumber( N-1, sum+=N);
    }

//    public static void binaryString(int N, int lastPlace, StringRecursion ans) {
//        if(N == 0) {
//            System.out.println(ans);
//            return;
//        }
//        binaryString(N-1, 0, ans+"0");
//        if(lastPlace == 0)
//            binaryString(N-1, 1, ans+"1");
//    }


//    public static void subsequence(int i, int[] arr, ArrayList<Integer> al, int sum) {
//        // base case
//        if (i == arr.length) {
//
//            System.out.println(al);
//            return;
//        }
//        al.add(arr[i]);
//        subsequence(i+1, arr, al);
//        al.remove(Integer.valueOf(arr[i]));
//        subsequence(i+1, arr, al);
//    }

     public static int sumOfDigit(int n, int sum) {
        if(n == 0) return sum;
        int rem = n % 10;
        return sumOfDigit(n/10, sum+rem);
     }

//     public static void reverseNumber(int n, int reverse, String str) {
//        if(n == 0) {
//            System.out.println(str);
//            return;
//        }
//        int rem = n % 10;
//        reverseNumber(n/10, reverse, str);
//
//     }

     public static int countNoOfZeros(int n, int count) {
        if(n == 0) return count;
        int rem = n % 10;
        if(rem == 0) count++;
        return countNoOfZeros(n/10, count);
     }

    public static void main(StringRecursion[] args) {
        // int n = 10;
        int[] arr = { 8, 3, 6 };
        // System.out.println(firstOccurance(arr, 5, 0));
        // System.out.println(lastOccurance(arr, 5, 0));
        // System.out.println(isSorted(arr, 0));
//        System.out.println(calcPower(5, 4));
        // printNum(n);
        // System.out.println(factorial(5));
        // System.out.println(sumofNatural(5));
//         System.out.println(fabbonacci(8));
//        System.out.println(sumOfNNumber(5, 0));
//        subsequence(0, arr, new ArrayList<>());
//        System.out.println(optimizedPower(2, 10));
//        binaryString(3, 0, "");
//        System.out.println(sumOfDigit(1234, 0));
        System.out.println(countNoOfZeros(123000345, 0));
    }
}
