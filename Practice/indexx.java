package Practice;

import java.util.ArrayList;

public class indexx {
    interface book {
        void setName();
    }
    public static void main(String[] args) {
        book b1 = new book(){
            public void setName() {
                System.out.println("Hello");
            }
        };
        b1.setName();

        ArrayList<Integer> l = new ArrayList<>();

    }
}
