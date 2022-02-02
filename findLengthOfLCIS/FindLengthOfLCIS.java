public class FindLengthOfLCIS {
    public static void main(String[] args) {
        FindLengthOfLCIS obj = new FindLengthOfLCIS();
        int[] nums = { 1, 3, 5, 4, 7 };
        obj.findLengthOfLCIS(nums);

    }

    public int findLengthOfLCIS(int[] nums) {
        int counts = 1, max = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] < nums[i]) {
                counts++;
            } else {
                max = Integer.max(counts, max);
                counts = 1;
            }
        }
        max = Integer.max(counts, max);
        return max;
    }
}