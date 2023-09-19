
 package Hashing;
import java.util.*;

public class FindItinerary {
    public static String findStart(Map<String, String> map) {
        Map<String, String> revMap = new HashMap<>();

        for(String s : map.keySet()) {
            revMap.put(map.get(s), s);
        }

        for(String s : map.keySet()) {
            if(revMap.get(s) == null) {
                return s;
            }
        }
        return null;
    }
    public static void main(String[] args) {
        String[][] journey = { { "Chennai", "Bengaluru" }, 
                                { "Mumbai", "Delhi" }, 
                                { "Goa", "Chennai" },
                                { "Delhi", "Goa" } };

        

        Map<String, String> map = new HashMap<>();
        for(int i=0; i<journey.length; i++) {
            map.put(journey[i][0], journey[i][1]);
        }

        String start = findStart(map);
        System.out.print(start);
        for(String s : map.keySet()) {
            System.out.print(" -> " + map.get(start));
            start = map.get(start); 
        }
    }
}
