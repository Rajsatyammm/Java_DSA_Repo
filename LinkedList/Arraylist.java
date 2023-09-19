package LinkedList;

import java.util.ArrayList;
import java.util.Scanner;

public class Arraylist {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    ArrayList<Integer> list = new ArrayList<>();
    ArrayList<Integer> list2 = new ArrayList<>();


    list.add(2);
    list.add(3);
    list.add(4);

    System.out.println(list);

    list.toArray();
    // for(int i=0; i<5; i++) {
    //     int data = sc.nextInt();
    //     list.add(data);
    // }
    
    //copy 
  }
}
