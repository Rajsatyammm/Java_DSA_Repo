package Stack;
import java.util.Stack;
public class ReverseString {

    public static Stack<Character> s = new Stack<>();

    public static void pushAtBottom(Stack<Integer> S, int val) {
        if (S.isEmpty()) {
            S.push(val);
            return;
        }

        int data = S.pop();
        pushAtBottom(S, val);
        S.push(data);
    }

    public static String reverse(String str) {
        for (int i = 0; i < str.length(); i++) {
            s.push(str.charAt(i));
        }

        StringBuilder result = new StringBuilder();
        while(!s.isEmpty()) {
            result.append(s.pop());
        }

        return result.toString();
    }

    public static void main(String[] args) {

        String str = "Hello World!";
        System.out.println(reverse(str));

    }
}
