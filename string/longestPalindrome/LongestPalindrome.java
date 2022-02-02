import java.util.HashMap;
import java.util.Map;

public class LongestPalindrome {
    public static void main(String[] args) {
        LongestPalindrome obj = new LongestPalindrome();
        // String s = "abccccdd";
        String s = "civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth";
        obj.longestPalindrome(s);
    }

    public int longestPalindrome(String s) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int n = s.length();
        // save the same character as a key, the numbers of the same character as a
        // value
        for (int i = 0; i < n; i++) {
            int val = 1;
            if (map.containsKey(s.charAt(i))) {
                val += map.get(s.charAt(i));
            }
            map.put(s.charAt(i), val);
        }
        // loop map
        int res = 0;
        byte odd = 0;//not contain odd number
        for (Map.Entry<Character, Integer> set : map.entrySet()) {
            if (set.getValue() % 2 == 0) {
                res += set.getValue();
            } else {
                res += set.getValue() - 1;
                odd = 1;//contain odd number
            }
        }
        return odd == 0 ? res : res + 1;
    }
}