
public class NextPermutation {
    public static void main(String[] args) {
        NextPermutation obj = new NextPermutation();
        // int[] nums = { 3, 2, 1 };
        // int[] nums = { 1, 5, 1 };
        int[] nums = {1, 2 , 2};
        // int[] nums = { 6, 5, 4, 8, 7, 5, 1 };
        obj.nextPermutation(nums);

    }

    public void nextPermutation(int[] nums) {
        /**
         * psedudecode:
         * 数组中的数字排列组合，存放在字典中，按照从小到大顺序存放。
         * 要求给出一个数组，返回数组中排列组合的下一位，如果这个数组排列组合在字典中最大，返回最小的排列组合
         * 6487651的下一位是87651中比4大的最小值是5，交换4和5的位置，87641按照有小到大，6514678
         * 1 把数组变为字典中的下一个排列组合
         * 2 for nums from backward
         *      compare the current one with the previous one
         *      if nums[i] <= nums[i - 1]
         *          then continue
         *      if nums is decending 
         *          then ascending(nums, 0, n-1) 
         *          return
         *      if nums[n - 1] > nums[n - 2]
         *          then swap(nums[n - 1], nums[n - 2])
         *      else find the min value's index in nums from index n-1 to i is bigger than nums[i - 1] 
         *          then swap(nums[the min value's index], nums[i - 1])
         *          then ascending(nums, i, n-1)
         *          return
         *   end
         */
        int n = nums.length;
        // if(n == 1){
        // return;
        // }
        for (int i = n - 1; i >= 0; i--) {
            if (i == 0) {// nums is descending
                ascending(nums, 0, n - 1);
                return;
            }
            // i - 1
            if (nums[i] <= nums[i - 1]) {
                continue;
            }
            if (i == n - 1) {// n-1 位比 n -2 位大
                ascending(nums, n - 2, n - 1);
                return;
            } else {
                int p = n - 1;
                while (nums[p] <= nums[i - 1]) {
                    p--;
                }

                // swap index (i - 1) and (p)
                int temp = nums[i - 1];
                nums[i - 1] = nums[p];
                nums[p] = temp;
                // ascending
                ascending(nums, i, n - 1);
                return;
            }
        }

    }

    private void ascending(int[] nums, int start, int end) {
        int left = start, right = end;
        while (left < right) {
            int temp = nums[right];
            nums[right] = nums[left];
            nums[left] = temp;
            left++;
            right--;
        }
    }
}