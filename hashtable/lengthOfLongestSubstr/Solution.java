import java.util.HashMap;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        String subString = "";
        
        // String key = "";
        
        int longest = 0;
        
        HashMap<String, String> map = new HashMap<String,String>();
        
        for(int i = 0; i < s.length(); i++){
            
            String key = String.valueOf(s.charAt(i));
                                    
            if(map.containsKey(key)){

                int n = subString.indexOf(key);

                subString = subString.substring(n+1);
                
            }

            subString += key;
            
            map.put(key, subString);
            
            if(longest < subString.length()){
                
                longest = subString.length();
                
            }
            
        }
        
        return longest;
    }
    public static void main(String[] args){
        Solution solution = new Solution();
        // int i = solution.lengthOfLongestSubstring("dvdf");
        // int i = solution.lengthOfLongestSubstring("abcabcbb");
        int i = solution.lengthOfLongestSubstring("tmmzuxt");
        // int i = solution.lengthOfLongestSubstring("pwwkew");
        System.out.println("the value i is: " + i);

    }
}