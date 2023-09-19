package Stack;

import java.util.Stack;

public class ReverseStack {

    public static void reverseStack(Stack<Integer> s) {
        if(s.isEmpty()) {
            return;
        }

        int top = s.pop();
        reverseStack(s);
        pushAtBottom(s, top);
    }
    public static void pushAtBottom(Stack<Integer> s, int val) {
        if(s.isEmpty()) {
            s.push(val);
            return;
        }

        int top = s.pop();
        pushAtBottom(s, val);
        s.push(top);
    }

    public static void print(Stack<Integer> s) {
        while(!s.isEmpty()) {
            System.out.println(s.pop());
        }
    }
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(5);
        s.push(6);
        s.push(7);
        pushAtBottom(s, 4);
        // print(s);
        reverseStack(s);
        print(s);
    }
}
