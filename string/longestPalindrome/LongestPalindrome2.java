public class LongestPalindrome2 {
    public static void main(String[] args) {
        LongestPalindrome2 obj = new LongestPalindrome2();
        String s = "abccccdd";
        // String s = "civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth";
        obj.longestPalindrome(s);
       
    }
    public int longestPalindrome(String s) {
        int[] arr = new int[128];
        for(char c: s.toCharArray()){
            arr[c]++;
        }
        int res = 0;
        byte odd = 0;
        for(int val: arr){
            res += val/2 * 2;
            if(val % 2 == 1){
                odd = 1;
            }
        }
        return odd == 0 ? res : res + 1;
    }
}