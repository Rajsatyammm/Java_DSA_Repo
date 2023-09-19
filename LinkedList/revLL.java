package LinkedList;
public class revLL {
    static class node {
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
        // empty Linked List
        if (head == null) {
            head = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    void AddLast(String data) {
        node newNode = new node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        node currNode = head;
        while (currNode.next != null) {
            currNode = currNode.next;
        }
        currNode.next = newNode;
    }

    void printLL() {
        if (head == null) {
            System.out.println("Empty Linked List : ");
            return;
        }
        node currNode = head;
        while (currNode != null) {
            System.out.print(currNode.data + " --> ");
            currNode = currNode.next;
        }
        System.out.println("null");
    }

    public void reverseIterate() {
        if (head == null || head.next == null) {
            return;
        }
        node prevNode = head;
        node currNode = head.next;
        while (currNode != null) {
            node nextNode = currNode.next;
            currNode.next = prevNode;

            // update
            prevNode = currNode;
            currNode = nextNode;
        }
        head.next = null;
        head = prevNode;
    }

    public node reverseRecursive(node head) {

        if (head == null || head.next == null) {
            return head;
        }
        node newNode = reverseRecursive(head.next);
        head.next.next = head;
        head.next = null;
        return newNode;
    }

    public static void main(String[] args) {
        revLL l1 = new revLL();
        l1.AddFirst("a");
        l1.AddFirst("is");
        l1.AddLast("list");
        l1.AddFirst("This");
        l1.printLL();
        l1.head = l1.reverseRecursive(l1.head);
        l1.printLL();
    }
}
