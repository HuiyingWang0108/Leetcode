
public class DecodeString {
    public static void main(String[] args) {
        DecodeString obj = new DecodeString();
        String s = "100[leetcode]";
        // String s = "3[a2[c]]";
        // String s = "2[abc]3[cd]ef";
        // String s = "3[z]2[2[y]pq4[2[jk]e1[f]]]ef";
        String res = obj.decodeString(s);
        System.out.println(res);

    }

    public String decodeString(String s) {
        // s consists of lowercase English letters, digits, and square brackets '[]'
        // All the integers in s are in the range [1, 300]
        int start_dig = 0;
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                start_dig = i;
                int num = 0;
                while (Character.isDigit(s.charAt(i))) {
                    num = num * 10 + Character.getNumericValue(s.charAt(i));
                    i++;
                }
                int count = 0, j;
                for (j = i; j < s.length(); j++) {
                    if (s.charAt(j) == '[') {
                        count++;
                    }
                    if (s.charAt(j) == ']') {
                        count--;
                    }
                    if (count == 0) {
                        break;
                    }
                }

                String repeat = decodeString(s.substring(i + 1, j));
                repeat = digit_s(num, repeat);
                if (j + 1 < s.length()) {
                    s = s.substring(0, start_dig) + repeat + s.substring(j + 1);
                    i = start_dig + repeat.length() - 2;
                } else {
                    s = s.substring(0, start_dig) + repeat;
                    break;
                }

            }

        }
        return s;
    }

    private String digit_s(int numericValue, String substring) {
        String ret = "";
        for (int k = 0; k < numericValue; k++) {
            ret += substring;
        }
        return ret;
    }
}