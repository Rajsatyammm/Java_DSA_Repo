
 package BitManipulation;
import java.util.*;

public class BitManipulation {

    public static void getIthBit(int n, int i) {
        int bitMask = 1 << i;
        if ((n & bitMask) == 0) {
            System.out.println("0");
        } else {
            System.out.println("1");
        }
    }

    public static int setIthBit(int n, int i) {
        int bitMask = 1 << i;
        return n | bitMask;
    }

    public static int clearIthBit(int n, int i) {
        int bitMask = ~(1 << i);
        return n & bitMask;
    }

    public static int updateIthBit(int n, int i, int newBit) {
        int bitMask = 1 << i;
        if(newBit == 0) {
            return clearIthBit(n, i);
        } else {
            return setIthBit(n, i);
        }
    }

    public static void main(String[] args) {

        // System.out.println(clearIthBit(10, 3));
        // System.out.println(updateIthBit(10, 2, 1));
        System.out.println();
    }
}
