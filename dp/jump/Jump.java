public class Jump {
    public static void main(String[] args) {
        Jump obj = new Jump();
        //[5,9,3,2,1,0,2,3,3,1,0,0]
        int[] nums = {5,9,3,2,1,0,2,3,3,1,0,0};
        obj.jump(nums);

    }

    public int jump(int[] nums) {
        /**
         * dp, Time complexity: O (n * n)
         *     space O(n)
         */
        int n = nums.length;
        //从index为i个元素跳最后所需最小步
        int[] dp = new int [n];
        
        if(nums[0] == 0){
            return Integer.MAX_VALUE;
        }
        for(int i = n - 2; i >= 0; i--){
            if(nums[i] == 0){
                dp[i] = 1000;
            }else if(nums[i] >= n - 1 - i){
                dp[i] = 1;
            }else if(nums[i] == 1){
                dp[i] = dp[i + 1] + 1;
            }else{
                int min = dp[i + 1];
                for(int j = 2; j <= nums[i]; j++){
                    min = Integer.min(min, dp[i + j]);
                }
                dp[i] = min + 1;
            }
        }
        return dp[0];
    }
}