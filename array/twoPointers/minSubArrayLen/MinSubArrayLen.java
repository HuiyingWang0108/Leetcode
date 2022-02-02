public class MinSubArrayLen {
    public static void main(String[] args) {
        MinSubArrayLen obj = new MinSubArrayLen();
        int[] nums = { 2, 3, 1, 2, 4, 3 };
        int target = 7;
        obj.minSubArrayLen(target, nums);
    }

    public int minSubArrayLen(int target, int[] nums) {
        int l = 0, r = 0, minLen = nums.length + 1, sum = 0;
        while (true) {
            if (sum < target) {
                sum += nums[r];
                if (r == nums.length) {
                    break;
                }
                r++;
            }
            if (sum >= target) {
                minLen = Integer.min(r - l, minLen);
                sum -= nums[l];
                l++;
            }
        }
        if (minLen == nums.length + 1) {
            return 0;
        }
        return minLen;
    }
}