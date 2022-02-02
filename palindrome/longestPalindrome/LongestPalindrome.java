public class LongestPalindrome{
    public static void main(String[] args){
        LongestPalindrome obj = new LongestPalindrome();
        String s = "aacabdkacaa";
        obj.longestPalindrome(s);
    }
    public String longestPalindrome(String s) {
        String res = "";
        int max = 0;
        int n = s.length();
        
        for(int i = 0; i < n; i++){
            char curr = s.charAt(i);
            int max_i = 1;
            String res_i = "" + curr;
            String left = "";
            String right = "";
            int m = i, k = i;
            while(m > 0){
                left += s.charAt(m - 1);
                m--;
            }
            while(k < n - 1){
                right += s.charAt(k + 1);
                k++;
            }
            //去与curr右边重复
            while(right.length() > 0 && curr == right.charAt(0)){
                res_i += curr;
                max_i += 1;
                right = right.substring(1);
                
            }
            boolean flg = true;
            while(left.length() > 0 && right.length() > 0){
                if(flg && left.charAt(0) == right.charAt(0)){
                    max_i += 2;
                    res_i = left.charAt(0) + res_i + right.charAt(0);
                }else{
                    flg = false;
                }
                left = left.substring(1);
                right = right.substring(1);
            }
            if(max < max_i){
                max = max_i;
                res = res_i;
            }
        }
        return res;
    }
}