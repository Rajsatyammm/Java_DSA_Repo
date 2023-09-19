package Hashing;
import java.util.*;
public class hm {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();

        map.put("india", 150);
        map.put("pak", 50);
        map.put("china", 100);

        // System.out.println(map);
        // System.out.println(map.containsKey("india"));
        System.out.println(map.get("pak"));

        Set<String> key = map.keySet();
        // System.out.println(key);

        for (String k : key) {
            System.out.println("Key : " + k + " , Value : " + map.get(k));
        }
    }
}
