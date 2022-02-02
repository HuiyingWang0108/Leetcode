
public class DecodeString2 {
    public static void main(String[] args) {
        DecodeString2 obj = new DecodeString2();
        // String s = "3[a]2[bc]";
        // String s = "3[a2[c]]";
        // String s = "2[abc]3[cd]ef";
        String s = "3[z]2[2[y]pq4[2[jk]e1[f]]]ef";
        String res = obj.decodeString(s);
        System.out.println(res);

    }

    public String decodeString(String s) {
        /**
         * wrong recursive!!!
         */

        //s consists of lowercase English letters, digits, and square brackets '[]'
        //All the integers in s are in the range [1, 300]
        int n = s.length();
        int num = 0;
        int i = 0;
        int start = 0, end = 0;
        String res = "";
        while(i < n && Character.isLowerCase(s.charAt(i))){
            res += s.charAt(i);
            i++;
        }
        while(i < n && Character.isDigit(s.charAt(i))){
            num = num * 10 + Character.getNumericValue(s.charAt(i));
            i++;
        }
        if(num != 0){
            start = i + 1;
            int count = 0;
            for(int k = i; k < n; k++){
                if(s.charAt(k) == '['){
                    count++;
                }
                if(s.charAt(k) == ']'){
                    count--;
                }
                if(count == 0){
                    end = k;
                    break;
                }
            }
        String end_s = "";
        if(end < n - 1){
            end_s = decodeString(s.substring(end + 1));
        }
        String m_sub_s = m_sub_s(num, s.substring(start, end));
        res = m_sub_s + end_s;
            
        }
        return res;
    }

    private String m_sub_s(int m, String sub_s) {
        String res = "";
        int n = sub_s.length();
        int num = 0;
        int i = 0;
        while(i < n && Character.isLowerCase(sub_s.charAt(i))){
            res += sub_s.charAt(i);
            i++;
        }
        while(i < n && Character.isDigit(sub_s.charAt(i))){
            num = num * 10 + Character.getNumericValue(sub_s.charAt(i));
            i++;
        }
        if(num != 0){
            int start = i + 1;
            int end = 0; 
            int count = 0;
            for(int k = i; k < n; k++){
                if(sub_s.charAt(k) == '['){
                    count++;
                }
                if(sub_s.charAt(k) == ']'){
                    count--;
                }
                if(count == 0){
                    end = k;
                }
            }
            if(end < n - 1){
                res = res + m_sub_s(num, sub_s.substring(start, end)) + decodeString(sub_s.substring(end + 1));
            }else{
                res += m_sub_s(num, sub_s.substring(start, end));
            }
            
        }
        String ret = "";
        for(int k = 0; k < m; k++){
            ret += res;
        }
        return ret;
    }
}