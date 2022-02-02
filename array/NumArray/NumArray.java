public class NumArray {
    public static void main(String[] args) {
        int[] nums = { -2, 0, 3, -5, 2, -1 };
        NumArray obj = new NumArray(nums);
        int param_1 = obj.sumRange(0, 2);
        int param_2 = obj.sumRange(2, 5);
        int param_3 = obj.sumRange(0, 5);
        System.out.println("param_1: " + param_1 + " param_2: " + param_2 + " param_3: " + param_3);

    }
    /**
     * 前缀和！
     */
    int[] preSum;
    public NumArray(int[] nums) {
        int n = nums.length;
        preSum = new int[n + 1];
        preSum[0] = 0;
        for(int i = 1; i <= n; i++){
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }

    }

    public int sumRange(int left, int right) {
        return preSum[right + 1] - preSum[left];
    }

}