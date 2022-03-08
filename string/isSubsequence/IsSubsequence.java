public class IsSubsequence {
    /**leetcode 392 */
    public static void main(String[] args) {

    }

    public boolean isSubsequence(String s, String t) {
        int p1 = 0, p2 = 0;
        int m = s.length();
        int n = t.length();
        if (m > n) {
            return false;
        }
        if (m == 0) {
            return true;
        }
        while (p2 < n) {
            if (s.charAt(p1) == t.charAt(p2)) {
                if (p1 == m - 1) {
                    return true;
                }
                p1++;
                p2++;
            } else {
                p2++;
            }
        }
        return false;
    }
}