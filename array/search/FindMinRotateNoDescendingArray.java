public class FindMinRotateNoDescendingArray {
    public static void main(String[] args) {
        FindMinRotateNoDescendingArray obj = new FindMinRotateNoDescendingArray();
        // int nums = { 4, 5, 6, 7, 0, 1, 4 };
        // int nums = { 2, 2, 2, 0, 1 };
        int[] nums = { 1, 3, 5 };
        obj.findMin(nums);

    }

    public int findMin(int[] nums) {
        /**
         * leetcode 154
         * 
         */
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = l + (r -l) / 2;
            if(nums[mid] > nums[r]){
                l = mid + 1;
            }else if(nums[mid] < nums[r]){
                r = mid;
            }else{//nums[mid] == nums[r]
                r--;
            }
        }
        return nums[r];
    }
}