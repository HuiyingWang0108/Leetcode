public class CountBits {
    /**leetcode: 338
     * ------example1----------
     *  Input: n = 2
        Output: [0,1,1]
        Explanation:
        0 --> 0
        1 --> 1
        2 --> 10
        ----example2: ----
        Input: n = 5
        Output: [0,1,1,2,1,2]
        Explanation:
        0 --> 0
        1 --> 1
        2 --> 10
        3 --> 11
        4 --> 100
        5 --> 101
     */
    public static void main(String[] args) {

    }

    public int[] countBits(int n) {
        if (n == 0) {
            return new int[] { 0 };
        }
        if (n == 1) {
            return new int[] { 0, 1 };
        }
        int[] res = new int[n + 1];
        res[0] = 0;
        res[1] = 1;
        for (int i = 2; i <= n; i++) {
            res[i] = res[i & (i - 1)] + 1;
        }
        return res;
    }
}