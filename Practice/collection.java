package Practice;
import java.util.*;
public class collection {
    class hello {
        public void add() {

        }
    }
    public static void main(String[] args) {
        List al = new ArrayList();
        al.add(2);
        al.add("hello");
        al.add("boy");
        al.add(2.5);
        for(int i=0; i<al.size(); i++) {
            System.out.println(al.get(i).getClass());
        }
    }
}
