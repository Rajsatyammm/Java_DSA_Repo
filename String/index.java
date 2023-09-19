 package String;
import java.util.*;
public class index {

    public static void tostring(String str) {
        StringBuilder sb = new StringBuilder("");
        // Character.toUpperCase(0);
        for (int i = 0; i < str.length() - 1; i++) {
            char ch = str.charAt(i);
            if (ch == ' ') {
                sb.append(ch); 
            } else {
                sb.append(ch);
            }
        }
        System.out.println(sb);
    }

    public static void main(String[] args) {
        // String str = "Hello";
        String str = "my name is raj";
        tostring(str);
    }
}
