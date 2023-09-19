
 package Practice;
import java.util.*;

public class hello {
    public static int compress(char[] chars) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < chars.length; i++) {
            char ch = chars[i];
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        StringBuilder str = new StringBuilder();
        for (char c : map.keySet()) {
            str.append(Character.toString(c));
            if(map.get(c) != 1)
            str.append(Integer.toString(map.get(c)));
        }
        System.out.println(str);
        return str.length();
    }

    public static void main(String[] args) {
        // char[] chars = { 'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b' };
        char[] chars = {'a','a','b','b','c','c','c'};
        System.out.println(compress(chars));
    }
}
