public class SingleNonDuplicate {
    /**
     * leecode 540
     * Input: nums = [1,1,2,3,3,4,4,8,8]
     * Output: 2
     * 
     * @param args
     */
    public static void main(String[] args) {
        // int[] nums = {0, 1, 1};
        // int[] nums = {1, 1, 2};
        int[] nums = { 1, 1, 2, 3, 3, 4, 4, 8, 8 };

        int res = singleNOnDuplicate(nums);
        System.out.println(res);

    }

    public static int singleNOnDuplicate(int[] nums) {
        /**
         * Time Complexity: O(n)
         */
        // for (int i = 0; i < nums.length; i = i + 2) {
        // if (i == nums.length - 1) {
        // return nums[i];
        // }
        // if (nums[i] == nums[i + 1]) {
        // continue;
        // } else {
        // return nums[i];
        // }
        // }
        // return nums[0];
        /**
         * BST:
         * Time COmplexity: O(log(n))
         */
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            if (left == right) {
                return nums[left];
            }
            int mid = left + (right - left) / 2;
            if (nums[mid] == nums[mid + 1]) {
                if (((right - mid + 1) & 1) == 0) {
                    right = mid - 1;
                } else {
                    left = mid;
                }
            } else if (nums[mid - 1] == nums[mid]) {
                if (((mid - left + 1) & 1) == 0) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            } else {
                return nums[mid];
            }
        }
        return nums[0];
    }
}