import java.util.Arrays;

public class ThreeSumClosest {
    public static void main(String[] args) {
        ThreeSumClosest obj = new ThreeSumClosest();
        int[] nums = { 1, 2, 4, 8, 16, 32, 64, 128 };
        int target = 82;
        int res = obj.threeSumClosest(nums, target);
        System.out.println(res);

    }

    public int threeSumClosest(int[] nums, int target) {
        // int n = nums.length;
        if (nums.length == 3) {
            return nums[0] + nums[1] + nums[2];
        }
        int n = nums.length;
        Arrays.sort(nums);
        int min_dif = 20000;
        int res = 0;
        for (int i = 0; i < n - 2; i++) {
            int left = i + 1, right = n - 1;
            while (left < right) {
                int sum_i = nums[i] + nums[left] + nums[right];
                int dif = Math.abs(target - sum_i);
                if (min_dif > dif) {
                    min_dif = dif;
                    res = sum_i;
                }
                if (target > sum_i) {
                    left++;
                }
                if (target < sum_i) {
                    right--;
                }
                if (target == sum_i) {
                    return target;
                }

            }
        }
        return res;

    }
}