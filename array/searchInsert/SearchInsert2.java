public class SearchInsert2 {
    public static void main(String[] args) {
        SearchInsert2 obj = new SearchInsert2();
        int[] nums = { 1, 3, 5, 6 };
        int target = 2;
        obj.searchInsert(nums, target);

    }

    public int searchInsert(int[] nums, int target) {
        int mid = 0, r = nums.length - 1, l = 0;
        while (l <= r) {
            mid = (l + r) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] < target)
                l++;
            else
                r--;

        }
        return l;

    }
}