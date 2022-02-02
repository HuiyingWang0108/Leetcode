import java.util.BitSet;

public class Intersection {
    public static void main(String[] args) {

        int[] nums1 = { 1, 2, 3 };
        BitSet bs1 = new BitSet();

        for (int k : nums1) {
            bs1.set(k);//
            bs1.get(k);// true
            System.out.println(k);
        }
    }

    public int[] intersection(int[] nums1, int[] nums2) {
        /**
         * leetcode 349
         * Given two integer arrays nums1 and nums2, return an array of their
         * intersection. Each element in the result must be unique and you may return
         * the result in any order.
         */
        // BitSet bs1 = new BitSet();
        // for (int num : nums1) {
        // bs1.set(num);
        // }
        // List<Integer> l = new ArrayList<>();
        // for (int num : nums2) {
        // if (bs1.get(num)) {
        // bs1.clear(num);
        // l.add(num);
        // }
        // }
        // int[] res = new int[l.size()];
        // for (int i = 0; i < l.size(); i++) {
        // res[i] = l.get(i);
        // }
        // return res;
        // ----------------------------------------------
        /**
         * step1, new BitSet bs1 and bs2
         * step2, for i=[0, nums1.length) do
         *            bs1.set(nums1[i])
         *        end
         * step2, for i=[0, nums2.length) do
         *           if (bs1.get(nums2[i]))
         *             then bs2.set(nums2[i]) and bs1.clear(nums2[i])
         *        end
         * step3, for i=[0, nums2.length) do
         *          if (bs2.get(nums2[i]))
         *             then save it to return array and bs2.clear(nums2[i])
         *        end
         * step4, return saved array
         * step5, end
         *                
         */
        BitSet bs1 = new BitSet();
        BitSet bs2 = new BitSet();
        for (int num : nums1) {
            bs1.set(num);
        }
        int c = 0;
        for (int num : nums2) {
            if (bs1.get(num)) {
                c++;
                bs2.set(num);
                bs1.clear(num);
            }
        }
        int[] res = new int[c];
        int k = 0;
        for (int num : nums2) {
            if (bs2.get(num)) {
                res[k++] = num;
                bs2.clear(num);
            }
        }
        return res;

    }
}