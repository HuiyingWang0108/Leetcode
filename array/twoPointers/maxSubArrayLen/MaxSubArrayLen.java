public class MaxSubArrayLen {
    public static void main(String[] args) {
        MaxSubArrayLen obj = new MaxSubArrayLen();
        int[] nums = { 2, 3, 1, 2, 4, 3 };
        int target = 7;
        obj.maxSubArrayLen(target, nums);
    }

    public int maxSubArrayLen(int target, int[] nums) {
        int l = 0, r = 0, maxLen = 0, sum = 0;
        while (true) {
            if (sum <= target) {
                sum += nums[r];
                maxLen = Integer.max(r - l, maxLen);
                if (r == nums.length) {
                    break;
                }
                r++;
            }
            if (sum > target) {
                sum -= nums[l];
                l++;
            }
        }
        if (maxLen == 0) {
            return 0;
        }
        return maxLen;
    }
}