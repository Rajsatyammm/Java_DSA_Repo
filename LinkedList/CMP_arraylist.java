package LinkedList;

import java.util.ArrayList;

public class CMP_arraylist {

    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> list1 = new ArrayList<>();

    
        list1.add(0, 1);
        list1.add(2);
        list1.add(5);

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(0, 60);
        list.set(0, 20);

        // list.clear();

        // list.remove(3);
        
        // if(list.contains(5)) {
        //     System.out.println("5 is present");
        // }

        // System.out.println(list.size());

        // System.out.println(list.indexOf(6));

        // if(list.isEmpty()) {
        //     System.out.println("Empty : ");
        // }
        // else {
        //     System.out.println("not empty");
        // }

        // list.removeAll(list1);

        // list.removeIf(e -> (e % 2 == 0));

        System.out.println(list);
        // int data = list.get(3);
        // System.out.println(data);
        // System.out.println(list);
    }
}
