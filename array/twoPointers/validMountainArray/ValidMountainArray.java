public class ValidMountainArray {
    public static void main(String[] args) {

    }

    public boolean validMountainArray(int[] arr) {
        /**
         * leetcode 941
         */
        int n = arr.length;
        if (n < 3) {
            return false;
        }
        int L = 0, R = n - 1;
        while (L < n - 2 && arr[L] < arr[L + 1]) {
            L++;
        }
        while (R > 1 && arr[R] < arr[R - 1]) {
            R--;
        }
        return L == R;
    }
}