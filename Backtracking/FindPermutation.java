package Backtracking;

public class FindPermutation {
    public static void findPermutation(String s, String ans) {
        if(s.length() == 0) {
            System.out.println(ans);
            return;
        }
        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            String newStr = s.substring(0, i) + s.substring(i+1);
            findPermutation(newStr, ans+ch);
        }
    }
    public static void main(String[] args) {
         String s = "abc";
         findPermutation(s, "");
    }
}
