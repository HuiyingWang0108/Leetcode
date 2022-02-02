public class MoveZeroes2 {
    public static void main(String[] args) {
        MoveZeroes2 obj = new MoveZeroes2();
        // int[] nums = {0, 0, 1};
        int[] nums = { 0, 1, 0, 3, 12 };
        obj.moveZeroes(nums);

    }

    public void moveZeroes(int[] nums) {
        /**
         * 类似 maxProfit
         * 计算第i个数时为0的个数count，第i个数左移count位
         * 让后最后count位赋值为 1
         */
        int n = nums.length;
        int count = 0;
        // for(int i = 0; i < n ;i++ ){
        //     if(nums[i] == 0){
        //         count++;
        //     }else{
        //         nums[i -count] = nums[i];
        //     }
        // }
        // for(int i = 1; i <= count; i++){
        //     nums[n - i] = 0;
        // }
        /**
         * 类似 maxProfit leetcode 283
         * 计算第i个数之前0的个数count，swap(nums[i], nums[i - count])
         * step1, move zeroes to the nums' end
         * step2, let count = 0
         * step3, for i = [0, nums.length) do
         *           if (nums[i] == 0) 
         *             then count++
         *           else
         *              then swap(nums[i], nums[i - count])
         *         end
         * step4, quit
         */
        for(int i = 0; i < n ;i++ ){
            if(nums[i] == 0){
                count++;
            }else{
                int temp = nums[i];
                nums[i] = nums[i - count];
                nums[i -count] = temp;
            }
        }
    }
}
