
public class FindMaxRotateNoDescendingArray {
    public static void main(String[] args) {
        FindMaxRotateNoDescendingArray obj = new FindMaxRotateNoDescendingArray();
        // int[] nums = { 4, 5, 6, 7, 0, 1, 4 };
        // int[] nums = { 2, 2, 2, 0, 1 };
        // int[] nums = { 1, 3, 5 };
        // int[] nums = { 6, 3, 5 };
        int[] nums = { 6, 3 };
        int res = obj.findMax(nums);
        System.out.println(res);

    }

    public int findMax(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            // int mid = l + (r -l) / 2;
            int mid = r - (r -l) / 2;
            if(nums[mid] > nums[l]){
                l = mid;
            }else if(nums[mid] < nums[l]){
                r = mid - 1;
            }else{//nums[mid] == nums[l]
                l++;
            }
        }
        return nums[l];
    }
}