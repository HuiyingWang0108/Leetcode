public class Jump2 {
    public static void main(String[] args) {
        Jump2 obj = new Jump2();
        //[5,9,3,2,1,0,2,3,3,1,0,0]
        int[] nums = {5,9,3,2,1,0,2,3,3,1,0,0};
        int res = obj.jump(nums);
        System.out.println(res);

    }

    public int jump(int[] nums) {
        /**
         * Greedy, Time complexity: O (n)
         *     space O(1)
         */
        int max_reach = 0, curr_reach = 0, jumps = 0;
        int n = nums.length - 1;
        for(int i = 0; i < n; i++){
            max_reach = Integer.max(max_reach, nums[i] + i);
            if(curr_reach == i){
                curr_reach = max_reach;
                jumps++;
            }
        }
        return jumps;
    }
}