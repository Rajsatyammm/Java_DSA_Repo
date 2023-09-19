
 package Hashing;
import java.util.*;

public class Anagrams {

    public static boolean isValid(Map<Character, Integer> map, String str) {
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (map.get(ch) != null) {
                int val = map.get(ch);
                if (val == 1) {
                    map.remove(ch);
                } else {
                    map.put(str.charAt(i), map.get(str.charAt(i)) - 1);
                }
            } else {
                return false;
            }
        }
        return map.isEmpty();
    }

    public static void main(String[] args) {
        String str1 = "race";
        String str2 = "care";
        // String str1 = "heart";
        // String str2 = "earth";
        // String str1 = "tulip";
        // String str2 = "lipid";

        // Map<Character, Integer> hm1 = func(new HashMap<Character, Integer>(), str1);
        // Map<Character, Integer> hm2 = func(new HashMap<Character, Integer>(), str2);

        // System.out.println(isAnagram(hm1, hm2));
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str1.length(); i++) {
            char ch = str1.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        System.out.println(isValid(map, str2));

    }
}
