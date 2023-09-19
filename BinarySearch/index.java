package BinarySearch;

public class index {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 3, 7, 8, 9, 9, 9, 11};
        int tar = 1;
        int ans = a.length;

        System.out.println(findLowerBound(0, a.length-1, a.length, tar, a));
    }

    static int findLowerBound(int low, int high, int ans, int tar, int[] a) {
        if(low > high) return ans;
        int mid = (low + high) / 2;
        if(a[mid] >= tar) {
            ans = mid;
            return findLowerBound(low, mid-1, ans, tar, a);
        } else {
            return findLowerBound(mid+1, high, ans, tar, a);
        }
    }
}
