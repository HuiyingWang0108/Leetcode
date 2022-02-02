public class AddBinary {
    public static void main(String[] args) {
        AddBinary obj = new AddBinary();
        String a = "1010";
        String b = "1011";
        obj.addBinary(a, b);

    }

    public String addBinary(String a, String b) {
        /**
         * time: O(max(m, n))
         * space:O(1)
         */
        String res = "";
        int k = 0;
        int m = a.length();
        int n = b.length();
        while (m > 0 && n > 0) {
            int a_char = Character.getNumericValue(a.charAt(m - 1));
            int b_char = Character.getNumericValue(b.charAt(n - 1));
            int s = a_char + b_char + k;
            if (s >= 2) {
                k = s >> 1;
                res = (s & 1) + res;
            } else {
                k = 0;
                res = s + res;
            }
            m--;
            n--;
        }
        while (m > 0) {
            int a_char = Character.getNumericValue(a.charAt(m - 1));
            int s = k + a_char;
            if (s >= 2) {
                k = s >> 1;
                res = (s & 1) + res;
            } else {
                k = 0;
                res = s + res;
            }

            m--;
        }
        while (n > 0) {
            int b_char = Character.getNumericValue(b.charAt(n - 1));
            int s = k + b_char;
            if (s >= 2) {
                k = s >> 1;
                res = (s & 1) + res;
            } else {
                k = 0;
                res = s + res;
            }

            n--;
        }
        if (k == 1) {
            res = k + res;
        }
        return res;
    }
}