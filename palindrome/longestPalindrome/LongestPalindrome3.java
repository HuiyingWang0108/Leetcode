public class LongestPalindrome3{
    public static void main(String[] args){
        LongestPalindrome3 obj = new LongestPalindrome3();
        String s = "babad";
        obj.longestPalindrome(s);
    }
    public String longestPalindrome(String s) {
        int l = 0, r = 0, max = 0, count;
        int n = s.length();
        for(int i = 0; i < n - 1; i++){
            if(s.charAt(i) == s.charAt(i + 1)){
                count = 0;
                for(int l_i = i, r_i = i+1; r_i < n && l_i >= 0; l_i--, r_i++){
                    if(s.charAt(l_i) == s.charAt(r_i)){
                        count++;
                    }else break;
                }
                if(max < 2 * count){
                    l = i - count + 1;
                    r = i + count;
                    max = 2 * count;
                }
            }
            if(i > 0 && s.charAt(i - 1) == s.charAt(i + 1)){
                count = 0;
                for(int l_i = i -1, r_i = i + 1; l_i >= 0 && r_i < n; l_i--, r_i++){
                    if(s.charAt(l_i) == s.charAt(r_i)){
                        count++;
                    }
                    else break;
                }
                if(max < 2 * count + 1){
                    l = i - count;
                    r = i + count;
                    max = 2 * count + 1;
                }
            }
        }
        return s.substring(l, r + 1);
    }
}