import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SingleNumber {
    public static void main(String[] args) {
        SingleNumber obj = new SingleNumber();
        int[] nums = { 2, 2, 2, 1 };// three same numbers
        // int[] nums = { 2, 2, 1 };//two same numbers 
        obj.singleNumber(nums);

    }

    public int singleNumber(int[] nums) {
        /**
         * ------------------------two same numbers-----------------------------------------
         * time O(nlogn)
         * space O(1)
         */
        // Arrays.sort(nums);
        // int n = nums.length;
        // for (int i = 0; i < n - 1; i += 2) {
        // if (nums[i] != nums[i + 1]) {
        // return nums[i];
        // }
        // }
        // return nums[n - 1];
        /**
         * time O(n)
         * space O(n)
         */
        // Set<Integer> set = new HashSet<Integer>();
        // int n = nums.length;
        // for (int i = 0; i < n; i++) {
        // if(set.add(nums[i])){
        // set.add(nums[i]);
        // }else{
        // set.remove(nums[i]);
        // }
        // }
        // return set.iterator().next();
        /**
         * time O(n)
         * space O(1)
         */
        // int res = 0;
        // for (int i = 0; i < nums.length; i++) {
        //     res ^= nums[i];
        // }
        // return res;
        /**
         * ------------------------three same numbers-----------------------------------------
         * two sets 
         * time O(n)
         * space O(n)
         */
        // Set<Integer> set_single = new HashSet<Integer>();
        // Set<Integer> set_duplicate = new HashSet<Integer>();
        // for (int i = 0; i < nums.length; i++) {
        //     if(!set_single.contains(nums[i]) && !set_duplicate.contains(nums[i])){
        //         set_single.add(nums[i]);
        //     }else if(!set_duplicate.contains(nums[i])){
        //         set_single.remove(nums[i]);
        //         set_duplicate.add(nums[i]);
        //     }
        // }
        // return set_single.iterator().next();
        /**
         * time O(nlogn)
         * space O(1)
         */
        Arrays.sort(nums);
        int n = nums.length;
        for(int i = 0; i < n - 1; i += 3){
            if(nums[i] != nums[i + 1]){
                return nums[i];
            }
        }
        return nums[n - 1];
    }
}