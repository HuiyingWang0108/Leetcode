import java.util.Arrays;
import java.util.List;

public class NextGreaterElement {
    public static void main(String[] args) {
        NextGreaterElement obj = new NextGreaterElement();
        int[] nums1 = { 4, 1, 2 };
        int[] nums2 = { 1, 3, 4, 2 };
        obj.nextGreaterElement(nums1, nums2);

    }

    // leetcode 496
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        /**
         * Time complexity O(m*?)
         * Space: O(n)
         */
        int m = nums1.length;
        int n = nums2.length;
        int[] res = new int[m];
        List<Integer> list = Arrays.stream(nums2).boxed().toList();
        for (int i = 0; i < m; i++) {
            int num = nums1[i];
            int p = list.indexOf(num);
            while (p < n) {
                if (p == n - 1) {
                    res[i] = -1;
                    break;
                }
                p++;
                if (num <= list.get(p)) {
                    res[i] = list.get(p);
                    break;
                }
            }
        }
        return res;
    }
}