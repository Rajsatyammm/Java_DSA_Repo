package Recursion;

public class StringRecursion {
    static String removeChar(String str, char ch, String ans, int i) {
        if(i == str.length()) return ans;
        char c = str.charAt(i);
        if(c != ch) {
            return removeChar(str, ch, ans+c, i+1);
        }
        return removeChar(str, ch, ans, i+1);
    }

    static void subsetRec(String str, String ans, int i) {
        if(i == str.length())  {
            if(ans.length() == 0) {
                System.out.println("null");
            }
            System.out.println(ans);
            return;
        }
        char ch = str.charAt(i);
        //include
        subsetRec(str, ans+ch, i+1);
        //not include
        subsetRec(str, ans, i+1);
    }

    static void subsetIterate(String str) {
        StringBuilder sb = new StringBuilder("");
        for(int i=0; i<str.length(); i++) {
            char ch = str.charAt(i);
            // include
            sb.append(ch);
        }
    }

    public static void main(String[] args) {
        String str = "sat";
//        System.out.println(removeChar(str, 'a', "", 0));
//        subsetRec(str, "", 0);
        subsetIterate(str);
    }
}
