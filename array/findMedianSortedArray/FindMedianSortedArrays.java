public class FindMedianSortedArrays {
    public static void main(String[] args){
        FindMedianSortedArrays obj = new FindMedianSortedArrays();
        int[] nums1 = {1,3};
        int[] nums2 = {2};
        double median = obj.findMedianSortedArrays(nums1, nums2);
        System.out.println("========median=======" + median);

        
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int i = 0, j = 0, k = 0;
        int nums1_l = nums1.length;
        int nums2_l = nums2.length;
        int[] nums = new int[nums1_l + nums2_l];
        while (i < nums1_l && j < nums2_l) {
            if (nums1[i] < nums2[j]) {
                nums[k++] = nums1[i++];
            } else {
                nums[k++] = nums2[j++];
            }
        }
        while (i < nums1_l) {
            nums[k++] = nums1[i++];
        }
        while (j < nums2_l) {
            nums[k++] = nums2[j++];
        }
        int mid = nums.length;
        if (mid % 2 == 1) {
            return nums[mid / 2] / 1.0;
        } else {
            return (nums[mid / 2 - 1] + nums[mid / 2]) / 2.0;
        }

    }
}