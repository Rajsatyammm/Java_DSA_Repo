package BitManipulation;

public class bit {
    public static void MagicNo(int n) {
        int ans = 0, base = 5;
        while(n != 0) {
            int last = n & 1;
            ans += ans * base;
            base = base * 5;
            n >>= 1;
        }
        System.out.println(ans);
    }

    public static void calculateBase(int base, int pow) {
        int ans = 1;
        while(pow > 0) {
            if((pow & 1) == 1) {
                ans *= base;
            }
            base *= base;
            pow >>= 1;
        }
        System.out.println(ans);
    }

    public static void main(String[] args) {
        int n = 5;
//        MagicNo(6);
        calculateBase(2, 4);
    }
}
