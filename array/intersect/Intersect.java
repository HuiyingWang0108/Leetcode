import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Intersect {
    public static void main(String[] args) {

        Intersect obj = new Intersect();
        int[] nums1 = { 4, 9, 5 }, nums2 = { 9, 4, 9, 8, 4 };
        obj.intersect(nums1, nums2);
    }

    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> list = new ArrayList<Integer>();
        int i = 0, j = 0;
        int n1 = nums1.length;
        int n2 = nums2.length;
        while (i < n1 && j < n2) {
            if (nums1[i] > nums2[j]) {
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                list.add(nums1[i]);
                i++;
                j++;
            }
        }
        int[] res = new int[list.size()];
        int k = 0;
        for (int l : list) {
            res[k++] = l;
        }
        return res;

    }
}