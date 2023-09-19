package Stack;
import java.util.ArrayList;
public class StackusingArrayLIst {
    public static ArrayList<Integer> list = new ArrayList<>();

    public boolean isEmpty() {
        return list.size() == 0;
    }

    public void push(int data) {
        list.add(data);
    }

    public int pop() {

        int val = list.get(list.size() - 1);
        list.remove(list.size() - 1);
        return val;
    }

    public int peek() {
        if (isEmpty()) {
            return -1;
        }
        return list.get(list.size() - 1);
    }

    public static void main(String[] args) {
        StackusingArrayLIst s = new StackusingArrayLIst();
        s.push(3);
        s.push(4);
        s.push(5);

        while (!s.isEmpty()) {
            System.out.println(s.pop());
        }

    }
}
