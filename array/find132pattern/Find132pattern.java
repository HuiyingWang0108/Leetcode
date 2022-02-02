public class Find132pattern {
    public static void main(String[] args) {
        Find132pattern obj = new Find132pattern();
        int[] nums = { 3, 1, 4, 2 };
        obj.find132pattern(nums);

    }

    public boolean find132pattern(int[] nums) {
        /**
         * leetcode 456
         */
        if (nums.length < 3) {
            return false;
        }
        int n = nums.length;
        for (int i = 1; i < n - 1; i++) {
            int min_left = Integer.MAX_VALUE;
            int max_right = Integer.MIN_VALUE;
            for (int j = 0; j < i; j++) {
                if (nums[j] < min_left) {
                    min_left = nums[j];
                    if (min_left < max_right && nums[i] > max_right) {
                        return true;
                    }
                }
            }

            for (int j = i + 1; j < n; j++) {
                if (nums[j] > max_right) {
                    max_right = nums[j];
                    if (min_left < max_right && nums[i] > max_right) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}