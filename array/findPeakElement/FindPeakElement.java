public class FindPeakElement {
    public static void main(String[] args) {
        FindPeakElement obj = new FindPeakElement();
        int[] nums = { 1, 2 };
        // int[] nums = { 1, 2, 1, 3, 5, 6, 4 };
        obj.findPeakElement(nums);
    }

    public int findPeakElement(int[] nums) {
        /**
         * two pointers
         * 
         */
        // int n = nums.length;
        // int left = 0, right = n - 1;
        // if (left <= right) {
        //     while (left + 1 < n && nums[left] < nums[left + 1]) {
        //         left++;
        //     }
        //     while (right - 1 > 0 && nums[right] < nums[right - 1]) {
        //         right--;
        //     }
        //     if (left == right) {
        //         return left;
        //     }
        // }
        // return left;
        /**
         * binary search
         * step1, find peak index in nums
         * step2, let low = 0, high = nums.length - 1
         * step3, let mid = (low + high) / 2
         * step4, while (low < high) do
         *           mid = (low + high) / 2
         *           if (nums[mid] < nums[mid + 1])
         *             then low = mid + 1
         *           else then high = mid
         * step5, return low
         */
        int low = 0, hight = nums.length - 1;
        int mid = (low + hight) / 2;
        while(low < hight){
            mid = (low + hight) / 2;
            if(nums[mid] < nums[mid + 1]){
                low = mid + 1;
            }else{
                hight = mid;
            }
        }
        return low;
    }
}