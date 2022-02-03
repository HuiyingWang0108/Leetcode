import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAnagrams {
    public static void main(String[] args) {
        FindAnagrams obj = new FindAnagrams();
        String s = "cbaebabacd";
        String p = "abc";
        obj.findAnagrams(s, p);

    }

    public List<Integer> findAnagrams(String s, String p) {
        /**
         * psesudocode
         * step0, let res = new ArrayList<Integer>()
         * step1: let arr1 = new int[26], to save string p
         * for i = [0, p.length()) do
         * let index = p.charAt(i) - 'a';
         * arr1[index] += 1;
         * step2, for i = [0, s.length() - p.length()] do
         * int l = i. r = i + p.length() - 1;
         * int index_l = l - 'a';
         * int index_r = r - 'a';
         * int[] arr2 = new int[26];
         * while (l < r) do
         * arr2[index_l] += 1;
         * arr2[index_r] += 1;
         * end
         * for i = [0, p.length()) do
         * if (arr1[i] != arr2[i]) then
         * l++
         * break
         * res.add(l);
         * 
         */
        List<Integer> res = new ArrayList<Integer>();
        int[] arr1 = new int[26];
        int m = s.length(), n = p.length();
        for (int i = 0; i < n; i++) {
            int index = p.charAt(i) - 'a';
            arr1[index] += 1;
        }
        int pointer = 0;
        while (pointer <= m - n) {
            int[] arr2 = new int[26];
            for (int i = pointer; i < pointer + n; i++) {
                int index = s.charAt(i) - 'a';
                arr2[index] += 1;
            }
            if(Arrays.equals(arr1, arr2)){
                res.add(pointer);
            }
            pointer++;
            
        }
        return res;
    }
}