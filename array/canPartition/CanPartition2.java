import java.util.Arrays;

public class CanPartition2 {
    public static void main(String[] args) {
        CanPartition2 obj = new CanPartition2();
        // int[] nums = { 3, 3, 3, 4, 5 };
        int[] nums = { 2, 2, 1, 1 };
        obj.canPartition(nums);

    }

    public boolean canPartition(int[] nums) {
        int sum = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }
        if (sum % 2 == 1) {
            return false;
        }
        sum = sum / 2;

        Arrays.sort(nums);
        if (nums[n - 1] > sum) {
            return false;
        } else if (nums[n - 1] == sum) {
            return true;
        }
        /**
         * 数组nums[n]中，存在i(1 =< i <n )个数之和为sum
         */
        boolean[][] dp = new boolean[n][sum + 1];

        for(int i = 0; i < n; i++){
            dp[i][0] = true;
        }
        for(int s = 0; s <= sum; s++){
            if(nums[0] == s){
                dp[0][s] = true;
            }
        }

        for(int i = 1; i < n; i++){
            for(int s = 1; s < sum + 1; s++){
                boolean excl = dp[i - 1][s];
                boolean incl = false;
                if(s >= nums[i]){
                    incl = dp[i - 1][s - nums[i]];
                }
                dp[i][s] = excl | incl;
            }
        }
        return dp[n - 1][sum];
        
    }

}