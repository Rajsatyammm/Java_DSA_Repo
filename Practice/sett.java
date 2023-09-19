package Practice;
import java.util.HashSet;
import java.util.Set;

public class sett {
    public static void main(String[] args) {
        Set<Integer> s = new HashSet<>();
        s.add(2);
        s.add(5);
        for(int i : s) System.out.print(i);
    }
}
