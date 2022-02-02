public class WordPattern {
    public static void main(String[] args) {
        /**
         * 
         * leetcode 290
         * 
         * pattern = "abba", s = "dog cat cat dog"
         * Output: true
         * 
         * Input: pattern = "abba", s = "dog cat cat fish" 
         * Output: false
         */

    }

    public boolean wordPattern(String pattern, String s) {
        String[] arr = s.split(" ");
        int m = pattern.length();
        int n = arr.length;
        if (m != n) {
            return false;
        }
        HashMap<String, Character> map = new HashMap<String, Character>();
        for (int i = 0; i < m; i++) {
            if (!map.containsKey(arr[i])) {
                if (pattern.indexOf(pattern.charAt(i)) != i) {
                    return false;
                }
                map.put(arr[i], pattern.charAt(i));
            } else {
                if (map.get(arr[i]) != pattern.charAt(i)) {
                    return false;
                }
            }

        }
        return true;
    }
}