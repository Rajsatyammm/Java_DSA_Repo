package Stack;
public class StackusingLL {

    public class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static Node head;

    public boolean isEmpty() {
        return head == null;
    }

    public void push(int data) {
        Node newNode = new Node(data);
        if (isEmpty()) {
            head = newNode;
            return;
        }

        newNode.next = head;
        head = newNode;
    }

    public int pop() {
        if (isEmpty()) {
            return -1;
        }

        int val = head.data;
        head = head.next;
        return val;
    }

    public int peek() {
        if (isEmpty()) {
            return -1;
        }

        return head.data;
    }

    public static void main(String[] args) {
        StackusingLL ll = new StackusingLL();
        ll.push(5);
        ll.push(6);
        ll.push(9);
        ll.push(10);

        System.out.println(ll.peek());
        // while(!ll.isEmpty()) {
        // System.out.print(ll.pop() + " ");
        // }
    }
}
