public class MaxSubArray{
    public static void main(String[] args){}
    public int maxSubArray(int[] nums) {
        /**
         * leetcode53
         */
        int max = Integer.MIN_VALUE;
        int sum = 0, n = nums.length;
        for(int i = 0; i < n; i++){
            sum += nums[i];
            max = Integer.max(max, sum);
            if(sum < 0){
                sum = 0;
            }
        }
        return max;
    }
}