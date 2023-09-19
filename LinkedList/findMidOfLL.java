package LinkedList;

public class findMidOfLL {
    class node {
        String data;
        node next;
    
        node(String data) {
            this.data = data;
            this.next = null;
        }
    }

    node head = null;

    void AddFirst(String data) {
        node newNode = new node(data);
        //empty Linked List
        if(head == null) {
            head = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    void AddLast(String data) {
        node newNode = new node(data);
        if(head == null) {
            head = newNode;
            return;
        }
        node currNode = head;
        while(currNode.next != null) {
            currNode = currNode.next;
        }
        currNode.next = newNode;
    }

    void printLL() {
        if(head == null) {
            System.out.println("Empty Linked List : ");
            return;
        }
        node currNode = head;
        while(currNode != null) {
            System.out.print(currNode.data + " --> ");
            currNode = currNode.next;
        }
        System.out.println("null");
    }

    public node findMid() {
        node rabbit = head;
        node turtle = head;

        while(rabbit.next != null && rabbit.next.next != null) {

            rabbit = rabbit.next.next;
            turtle = turtle.next;
        }
        return turtle;
    }

    public static void main(String[] args) {
        
        findMidOfLL l1 = new findMidOfLL();
        l1.AddFirst("a");
        l1.AddFirst("is");
        l1.AddLast("list");
        l1.AddFirst("This");
        // l1.AddLast("ok");

        node val = l1.findMid();
        System.out.println(val.data);
        l1.printLL();
    }
}
