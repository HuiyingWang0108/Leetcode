public class SearchRotateAscendingArrary {
    public static void main(String[] args) {
        SearchRotateAscendingArrary obj = new SearchRotateAscendingArrary();
        int target = 1;
        int[] nums = { 3, 1 };
        // int[] nums = { 4, 5, 6, 7, 0, 1, 2 };
        obj.search(nums, target);

    }

    public int search(int[] nums, int target) {
        /**
         * step1, let low = 0, high = n - 1
         * step2, if (nums.length == 1 && target == nums[0]) then
         *           return 0
         * step3, while (low <= high) do
         *           let mid = low + (high - low) / 2
         *           if (target == nums[mid]) 
         *              then return mid
         *           if (nums[mid] >= nums[low])
         *              then if (target >= nums[low] && target < nums[mid])
         *                     then 
         * 
         * 
         * 
         * 
         * 
         */
        // if (nums.length == 1 && target == nums[0]) {
        //     return 0;
        // }
        int n = nums.length;
        int low = 0, high = n - 1;
        // Rotated Sorted Array
        while (low <= high) {
            int mid = low + (high - low) / 2;//in case overflow
            if (target == nums[mid]) {
                return mid;
            }
            if (nums[mid] >= nums[low]) {
                if (target >= nums[low] && target < nums[mid]) {//left side is in asending order
                    high = mid - 1;
                } else {//target in right part of the array
                    low = mid + 1;
                }
            } else {
                if (target <= nums[high] && target > nums[mid]) {//righ side is in asending order 
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;

    }
}