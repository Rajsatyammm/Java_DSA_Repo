package LinkedList;

import java.util.LinkedList;
import java.util.Collections;

public class CMP_linkedlist {

    public static void main(String[] args) {

        LinkedList<Integer> list = new LinkedList<>();

        list.addFirst(5);
        list.addFirst(7);
        list.add(9);
        list.addLast(10);

        // System.out.println("First item is " + list.getFirst());
        // System.out.println("Last item is " + list.getLast());

        // list.removeLast();
        // list.remove();
        
        // if(list.contains(10)) {
        //     System.out.println("10 is present in the list");
        // }

        // list.removeIf(e -> (e % 2 == 0));
        // list.removeIf(e -> (e % 2 != 0));

        // if(list.isEmpty()) {
        //     System.out.println("Empty list");
        // }

        // System.out.println(list.size());

        // Collections.reverse(list);
        Collections.sort(list);

        System.out.println(list);
    }
}
