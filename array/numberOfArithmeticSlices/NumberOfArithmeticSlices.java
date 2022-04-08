public class NumberOfArithmeticSlices{
    //leetcode 413
    public static void main(String[] args) {
        NumberOfArithmeticSlices obj = new NumberOfArithmeticSlices();
        int[] nums = {1, 1, 1, 1};
        int ret = obj.numberOfArithmeticSlices(nums);
        System.out.println(ret);
        
    }
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        if(n < 3) return 0;
        int count = 0;
        int ret = 0;
        for(int i = 1; i < n - 1; i++){
            if(nums[i + 1] - nums[i] == nums[i] - nums[i - 1]){
                count++;
                ret += count;
            }else{
                count = 0;
            }
        }
        return ret;
    }
}