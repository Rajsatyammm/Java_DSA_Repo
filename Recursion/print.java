package Recursion;/*
 Q. Print all possible strings of length k that can be formed from a set of n   characters
 */

public class print {
    public static void printString(char[] ch, int k, String str) {
        //base case
        if(k == 0) {
            System.out.println(str);
            return;
        }
        // kaam
        char c0 = ch[0];
        char c1 = ch[1];
        printString(ch, k-1, str+c0);
        printString(ch, k-1, str+c1);
    }
    public static void main(String[] args) {
        char[] ch = {'a', 'b'};
        printString(ch, 3, "");
    }
}