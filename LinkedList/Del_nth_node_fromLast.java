package LinkedList;

public class Del_nth_node_fromLast {

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

    public node nthFromLast(int n) {

        //calculate size
        int size = 0;
        node curr = head;
        while(curr != null) {
            size++;
            curr = curr.next;
        }

        if(n == size) {
            return head.next;
        }

        int indexFromStart = size - n;
        int i = 1;
        curr = head;
        while(i < indexFromStart) {
            curr = curr.next;
            i++;
        }
        node currNode = curr.next;
        // System.out.println(n + " Node from last is --> " + currNode.data);

        //break the link
        curr.next = curr.next.next;
        return head;
    }


    public static void main(String[] args) {
        
        Del_nth_node_fromLast l1 = new Del_nth_node_fromLast();
        l1.AddFirst("a");
        l1.AddFirst("is");
        l1.AddLast("list");
        l1.AddFirst("This");

        l1.printLL();
        node hello = l1.nthFromLast(1);
        l1.printLL();


    }
}
