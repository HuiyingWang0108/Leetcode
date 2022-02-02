public class FindMinRotateAscendingArrary {
    public static void main(String[] args) {
        FindMinRotateAscendingArrary obj = new FindMinRotateAscendingArrary();
        int[] nums = { 4, 5, 6, 7, 1, 2, 3 };
        int res = obj.findMin(nums);
        System.out.println(res);
    }

    public int findMin(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (mid > 0 && nums[mid - 1] > nums[mid]) {
                return nums[mid];
            } else if (nums[l] <= nums[mid] && nums[mid] > nums[r]) {
                l = mid + 1;
            } else
                r = mid - 1;

        }
        return nums[l];
    }
}