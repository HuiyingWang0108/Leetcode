import java.util.ArrayList;
import java.util.List;

public class ItemsInContainers{
    public static void main(String[] args) {
        String s = "|**|*|*";
        List<Integer> startIndices = new ArrayList<Integer>();
        startIndices.add(1);
        startIndices.add(1);
        startIndices.add(2);
        List<Integer> endIndices = new ArrayList<Integer>();
        endIndices.add(5);
        endIndices.add(6);
        endIndices.add(7);
        List<Integer> ans = itemsInContainers(s, startIndices, endIndices);
        for (Integer i : ans) {
            System.out.println(i);
        }
        
    }
    public static List<Integer> itemsInContainers(String s, List<Integer> startIndices, List<Integer> endIndices) {
        /**
         * Time Complexity: s.length() + startIndices.size()
         * Space Complexity: O(s.length())
         */
        List<Integer> ans = new ArrayList<Integer>();
        for(int i = 0; i < startIndices.size(); i++) {
            int start = startIndices.get(i) - 1;
            int end = endIndices.get(i) - 1;
            while(s.charAt(start) != '|') {
                start++;
            }
            while(s.charAt(end) != '|') {
                end--;
            }
            if(start < end) {
                int count_start = countInIndice(s, start);
                int count_end = countInIndice(s, end);
                int items = count_end -count_start;
                ans.add(items);
            }else {
                ans.add(0);
            }
            
        }
        return ans;
    }
    static int countInIndice(String s, int indice) {
        int n = s.length();
        int[] dp = new int[n];
        int count = 0;
        for(int i = 0; i < n; i++) {
            if(s.charAt(i) == '|') {
                dp[i] = count;
            }else {
                count++;
            }
        }
        return dp[indice];
    }

}