
public class FindMaxRotateAscendingArrary {
    public static void main(String[] args) {
        FindMaxRotateAscendingArrary obj = new FindMaxRotateAscendingArrary();
        // int[] nums = { 4, 5, 6, 7, 1, 2, 3 };
        // int[] nums = { 4, 5, 1, 2, 3 };
        // int[] nums = {1,2,3};
        int[] nums = {1};

        int res = obj.findMax(nums);
        System.out.println(res);

    }

    public int findMax(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (mid > 0 && nums[mid - 1] < nums[mid] && nums[mid] > nums[mid + 1]) {
                return nums[mid];
            } else if (nums[l] >= nums[mid] && nums[l] > nums[r]) {
                r = mid - 1;
            } else l = mid + 1;
                

        }
        return nums[l];
    }
}