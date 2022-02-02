public class SearchInsert {
    public static void main(String[] args) {
        SearchInsert obj = new SearchInsert();
        int[] nums = { 1, 3, 5, 6 };
        int target = 2;
        obj.searchInsert(nums, target);

    }

    public int searchInsert(int[] nums, int target) {
        int n = nums.length;
        int res = 0;
        if (target < nums[0]) {
            return 0;
        }
        if (target > nums[n - 1]) {
            return n;
        }
        for (int i = 0; i < n; i++) {
            if (target == nums[i]) {
                res = i;
            }
            if (i < n - 1 && target > nums[i] && target < nums[i + 1]) {
                res = i + 1;
            }
        }
        return res;

    }
}