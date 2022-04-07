import java.util.Arrays;

public class LargestNumber{
    // leecode :179
    public static void main(String[] args) {
        
    }
    public String largestNumber(int[] nums) {
        String res = "";
          String[] strArry = new String[nums.length];
          for(int i = 0; i < nums.length; i++){
              strArry[i] = Integer.toString(nums[i]);
          }
          //very important function!!!
          Arrays.sort(strArry, (String s1, String s2) -> (s2+s1).compareTo(s1+s2));
          for(String str: strArry){
              res += str;
          }
          if(res.charAt(0) == '0'){
                  return "0";
              }
          return res;
      }
}