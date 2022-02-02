public class LongestPalindrome2{
    public static void main(String[] args){
        LongestPalindrome2 obj = new LongestPalindrome2();
        String s = "abcba";
        obj.longestPalindrome(s);
    }
    public String longestPalindrome(String s) {
        int n = s.length();
        int max = 0;
        String res = "";
        for(int i = 0; i < n; i++){
            char curr = s.charAt(i);
            int k = 1;
            int m = i, l = i, r = i;
            int max_i = 1;
            String res_i = String.valueOf(curr);
            if(m < n - 1 && s.charAt(m) == s.charAt(m + 1)){
                while(m < n - 1 && s.charAt(m) == s.charAt(m + 1)){
                    max_i += 1;
                    res_i += s.charAt(m + 1);
                    m++;
                    k++;
                }
            }
           if(l > 0 && r < n - k && s.charAt(l - 1) == s.charAt(r + k)){
                while(l > 0 && r < n - k && s.charAt(l - 1) == s.charAt(r + k)){
                    max_i += 2;
                    res_i = s.charAt(l - 1) + res_i + s.charAt(r + k);
                    l--;
                    // r++;
                    k++;
                }
           }
            
            if(max < max_i){
                max = max_i;
                res = res_i;
            }
        }
        return res;
    }
}