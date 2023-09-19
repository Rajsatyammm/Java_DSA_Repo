package LinkedList;

public class LinkedList {
    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }

        Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    static Node head = null;
    static Node tail = null;
    static int size;

    public void AddFirst(int data) {
        Node newNode = new Node(data);
        // empty Linked List
        if (head == null) {
            head = tail = newNode;
            size++;
            return;
        }
        size++;
        newNode.next = head;
        head = newNode;
    }

    public void AddLast(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node currNode = head;
        while (currNode.next != null) {
            currNode = currNode.next;
        }
        size++;
        currNode.next = newNode;
    }

    public void add(int data, int idx) {
        Node newNode = new Node(data);
        Node currNode = head;
        if (idx == 0) {
            AddFirst(data);
            return;
        }
        int i = 1;
        while (i < idx) {
            currNode = currNode.next;
            i++;
        }
        size++;
        newNode.next = currNode.next;
        currNode.next = newNode;
    }

    public void printLL() {
        if (head == null) {
            System.out.println("Empty Linked List : ");
            return;
        }
        Node currNode = head;
        while (currNode != null) {
            System.out.print(currNode.data + " --> ");
            currNode = currNode.next;
        }
        System.out.println("null");
    }

    public void deleteFirst() {
        if (head == null) {
            size = 0;
            return;
        }
        size--;
        head = head.next;
    }

    public void deleteLast() {
        if (head == null) {
            size = 0;
            return;
        }

        Node currNode = head;
        while (currNode.next.next != null) {
            currNode = currNode.next;
        }
        size--;
        currNode.next = null;
    }

    public void deleteFromLast(int i) {
        Node currNode = head;
        int idx = size - i;
        if (idx == 0) {
            deleteFirst();
            return;

        }
        if (idx == size) {
            deleteLast();
            return;
        }
        int j = 1;
        while (j < idx) {
            currNode = currNode.next;
            j++;
        }
        size--;
        currNode.next = currNode.next.next;
    }

    public Node findMid(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public void reverse() {
        Node prev = null;
        Node curr = head;

        while (curr != null) {
            Node nextP = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextP;
        }
        head = prev;
    }

    public Node reverse(Node head) {
        Node prev = null;
        Node curr = head;

        while (curr != null) {
            Node nextP = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextP;
        }
        return prev;
    }

    public Node reverseRec(Node head) {
        if(head == null) {
            return null;
        }
        Node newNode = reverseRec(head.next);
        head.next.next = head;
        head.next = null;
        return head;
    }

    public boolean cheakPalindrome() {
        // Find mid
        Node mid = findMid(head);

        // reverse head2 half
        Node rightHead = reverse(mid);
        Node leftHead = head;

        // cheak palindrome
        while (rightHead != null) {
            if (rightHead.data != leftHead.data) {
                return false;
            }
            rightHead = rightHead.next;
            leftHead = leftHead.next;
        }
        return true;
    }

    public boolean hasCycle() {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next;

            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

    public void removeCycle() {
        Node slow = head;
        Node fast = head;
        boolean cycle = false;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (fast == slow) {
                cycle = true;
                break;
            }
        }
        if (cycle == false) {
            return;
        }

        slow = head;
        Node prev = null;
        while (fast != slow) {
            prev = fast;
            fast = fast.next;
            slow = slow.next;
        }
        // remove loop
        prev.next = null;

    }

    public void printRecursive(Node head) {
        Node currNode = head;
        // base case
        if (currNode == null) {
            return;
        }
        System.out.print(currNode.data + " ");
        printRecursive(currNode.next);
    }

    public Node getMid(Node head) {
        Node slow = head;
        Node fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public Node merge(Node head1, Node head2) {
        Node temp = new Node(-1);
        Node curr = temp;

        while (head1 != null && head2 != null) {
            if (head1.data <= head2.data) {
                curr.next = head1;
                head1 = head1.next;
            } else {
                curr.next = head2;
                head2 = head2.next;
                // temp = temp.next;
            }
            temp = temp.next;
        }

        while (head1 != null) {
            curr.next = head1;
            head1 = head1.next;
            temp = temp.next;
        }

        while (head2 != null) {
            curr.next = head2;
            head2 = head2.next;
            temp = temp.next;
        }

        return temp.next;
    }

    public Node mergeSort(Node head) {
        // base case
        if (head == null || head.next == null) {
            return head;
        }
        // find mid
        Node mid = getMid(head);

        // left & right MS
        Node rightHead = mid.next;
        mid.next = null;
        Node newLeft = mergeSort(head);
        Node newRight = mergeSort(rightHead);

        // merge
        return merge(newLeft, newRight);
    }

    public void zigZagLL() {
        Node mid = getMid(head);
        Node head2 = reverse(mid.next);
        mid.next = null;

        Node left = head;
        Node right = head2;
        Node nextL, nextR;
        while (left != null && right != null) {
            // zig zag step
            nextL = left.next;
            left.next = right;
            nextR = right.next;
            right.next = nextL;

            // updation step
            left = nextL;
            right = nextR;
        }
    }


    // Recursion
//    public void addRec(int idx, int val, Node prev, Node curr) {
//        while(idx != 0) {
//            addRec(idx - 1, val, curr, curr.next);
//            return;
//        }
//        Node newNode = new Node(val);
//        size++;
//        newNode.next = curr;
//        prev.next = newNode;
//    }

    public void adding(int idx, int val, Node prev, Node curr) {

        Node head = addRec(idx, val, prev, curr);
    }
    public Node addRec(int idx, int val, Node prev, Node curr) {
        if(idx == 0) {
            Node newNode = new Node(val, curr);
            size++;
            prev.next = newNode;
            return newNode;
        }
        return addRec(idx-1, val, curr, curr.next);
    }

    public static void main(String[] args) {

        LinkedList ll = new LinkedList();
        // head = ll.new Node(1);
        // Node temp = ll.new Node(10);
        // head.next = temp;
        // head.next.next = ll.new Node(3);
        // head.next.next.next = temp;

        // System.out.println(ll.hasCycle());
        // ll.removeCycle();
        // System.out.println(ll.hasCycle());

        ll.AddFirst(3);
        ll.AddFirst(3);
        ll.AddLast(4);
        ll.AddFirst(4);
        ll.add(9, 2);
        // ll.add(9, 2);
        // ll.printLL();
        // ll.deleteFromLast(2);
        // ll.deleteFirst();
        // ll.deleteLast();
        // ll.reverse();
        // System.out.println("size of LL is : " + size);
//        ll.printLL();
//        head = ll.mergeSort(head);
        // ll.zigZagLL();
//        ll.addRec(3, 10, null, head);
        ll.adding(3, 50, null, head);
        ll.printLL();
        head = ll.reverseRec(head);
        ll.printLL();
//        System.out.println(size);
        // System.out.println(ll.cheakPalindrome());
    }
}
