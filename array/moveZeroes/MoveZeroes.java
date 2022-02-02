public class MoveZeroes {
    public static void main(String[] args) {
        MoveZeroes obj = new MoveZeroes();
        // int[] nums = {0, 0, 1};
        int[] nums = { 0, 1, 0, 3, 12 };
        obj.moveZeroes(nums);

    }

    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int count = 0;
        int i = 0;
        while (i < n - count) {
            if (nums[i] == 0) {
                for (int j = i + 1; j < n - count; j++) {
                    nums[j - 1] = nums[j];// shif left
                }
                count++;
                nums[n - count] = 0;// insert last index
            }else{
                i++;
            }
        }

    }
}
