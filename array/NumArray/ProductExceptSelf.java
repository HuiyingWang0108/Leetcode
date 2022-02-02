public class ProductExceptSelf {
    public static void main(String[] args) {
        ProductExceptSelf obj = new ProductExceptSelf();
        int[] nums = { 1, 2, 3, 4 };
        obj.productExceptSelf(nums);

    }

    /**
     * You must write an algorithm that runs in O(n) time and without using the
     * division operation.
     * 
     * @param nums
     * @return
     */
    public int[] productExceptSelf(int[] nums) {
        /**
         * pseudocode
         * 1, get productExceptSelf multipile
         * 2, let pre_nums_ascending[] = new int[nums.length],
         * 3, let pre_nums_ascending[0] = 1
         * 4, iteration nums as ascending order
         *    for (int i = 1; i < nums.length; i++) do
         *        pre_nums_ascending[i] = pre_nums_ascending[i - 1] * nums[i - 1]
         *    end
         * 5, let pre_nums_descending[] = new int[nums.length],
         * 6, let pre_nums_descending[n - 1] = 1
         * 7, iteration nums as descending order
         * 8, for (int i = nums.length - 2; i >= 0; i--) do
         *       pre_nums_descending[i] = pre_nums_descending[i + 1] * nums[i + 1]
         *    end
         * 9, for (int i = 0; i < nums.length; i++) do
         *       nums[i] = pre_nums_descending[i] * pre_nums_ascending[i];
         *    end
         *10, return nums
         *11, quit
         */
        int n = nums.length;
        int[] pre_nums_ascending = new int[n];
        pre_nums_ascending[0] = 1;
        for (int i = 1; i < n; i++) {
            pre_nums_ascending[i] = pre_nums_ascending[i - 1] * nums[i - 1];
        }
        int[] pre_nums_descending = new int[n];
        pre_nums_descending[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            pre_nums_descending[i] = pre_nums_descending[i + 1] * nums[i + 1];
        }
        for (int i = 0; i < n; i++) {
            nums[i] = pre_nums_ascending[i] * pre_nums_descending[i];
        }
        return nums;

    }
}