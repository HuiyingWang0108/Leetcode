import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate{
    //leecode 217
    public static void main(String[] args) {
        
    }
    public boolean containsDuplicate(int[] nums) {
        /**
         * time: O(nlogn)
         * space: O(1)
         */
        // Arrays.sort(nums);
        // for(int i = 0; i < nums.length - 1; i++){
        //     if(nums[i] == nums[i + 1]){
        //         return true;
        //     }
        // }
        // return false;
        /**
         * time: O(n)
         * space: O(n)
         */
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length; i++){
            if(!set.add(nums[i])){
                return true;
            }
        }
        return false;
    }
}