public class MaxCoins {
    public static void main(String[] args) {
        MaxCoins obj = new MaxCoins();
        int[] nums = {3, 1, 5, 8};
        obj.maxCoins(nums);

    }

    public int maxCoins(int[] nums) {
        int res = 0;
        int n = nums.length;
        if (n == 1) {
            res = nums[0];
            return res;
        }
        if (n == 2) {
            res = nums[0] * nums[1] + Integer.max(nums[0], nums[1]);
            return res;
        }
        if (n == 3) {
            int[] nums_d = { nums[0], nums[2] };
            res = nums[0] * nums[1] * nums[2] + maxCoins(nums_d);
        }
        if (n > 3) {
            int min = 101;
            for (int i = 0; i < n; i++) {
                if (min > nums[i]) {
                    min = nums[i];
                }
            }
            int[] nums_d = new int[n - 1];
            byte flag = 1;
            int m = 0;
            int k = 0;
            for (int i = 0; i < n; i++) {
                if (min == nums[i] && flag == 1) {
                    m = i;
                    flag = 0;
                    continue;
                }
                nums_d[k++] = nums[i];
            }
            if (m == 0) {
                res = nums[0] * nums[1] + maxCoins(nums_d);
            } else if (m == n - 2) {
                res = nums[m - 1] * nums[m] + maxCoins(nums_d);
            } else {
                res = nums[m - 1] * nums[m] * nums[m + 1] + maxCoins(nums_d);
            }
        }
        return res;
    }
}