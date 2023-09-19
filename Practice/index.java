 package Practice;
import java.util.*;
public class index {
    static void subset(String str, String ans, int i) {
        if(i == str.length()) {
            if(ans.length() == 0) {
                System.out.print("null ");
            }
            else {
                System.out.print(ans + " ");
            }
            return;
        }
        char ch = str.charAt(i);
        subset(str, ans+ch, i+1);
        subset(str, ans, i+1);
    }
    public static void main(String[] args) {
        String str = "abc";
        subset(str, "", 0);
    }
}
