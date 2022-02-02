import java.util.Arrays;

public class RotateRight {
    public static void main(String[] args) {
        RotateRight obj = new RotateRight();
        int k = 3;
        int[] nums = {1,2,3,4,5,6,7};
        obj.rotate(nums, k);
        System.out.println(Arrays.toString(nums));
    }

    public void rotate(int[] nums, int k) {
        /**
         * space: O(1)
         * time: O(n)
         * leetcode:189
         * Input: nums = [1,2,3,4,5,6,7], k = 3
         * Output: [5,6,7,1,2,3,4]
         * rotate 1 steps to the right: [7,1,2,3,4,5,6]
         * rotate 2 steps to the right: [6,7,1,2,3,4,5]
         * rotate 3 steps to the right: [5,6,7,1,2,3,4]
         */
        int n = nums.length;
        k = k % n;
        reverseNums(nums, 0, n - 1);
        reverseNums(nums, 0, k - 1);
        reverseNums(nums, k, n - 1);
    }

    private void reverseNums(int[] nums, int start, int end) {
        while(start < end){
            int temp = nums[end];
            nums[end] = nums[start];
            nums[start] = temp;
            end--;
            start++;
        }
    }
}
