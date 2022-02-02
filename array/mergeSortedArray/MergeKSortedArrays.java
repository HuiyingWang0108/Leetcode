import java.util.Arrays;

public class MergeKSortedArrays {
    public static void main(String[] args) {
        MergeKSortedArrays obj = new MergeKSortedArrays();
        int[][] arrs = { { 1, 2 }, { 2, 4 }, { 5, 9 }, { 3, 8, 9 } };
        // int[][] arrs = {{1}};
        int[] res = obj.mergeKSortedArrays(arrs);
        System.out.println(Arrays.toString(res));
    }

    public int[] mergeKSortedArrays(int[][] arrs) {
        int k = arrs.length;
        if (k == 0) {
            return new int[0];
        }
        if (k == 1) {
            return arrs[0];
        }
        while (k > 1) {
            int start = 0, end = k - 1;
            while (start < end) {
                arrs[start] = mergeTwoArrays(arrs[start], arrs[end]);
                start++;
                end--;
                if (start >= end) {
                    k = end + 1;
                }
            }
        }
        return arrs[0];
    }

    public static int[] mergeTwoArrays(int[] arr_1, int[] arr_2) {
        int m = arr_1.length;
        int n = arr_2.length;
        int i = 0, j = 0, k = 0;
        int[] res = new int[m + n];
        if (m == 0) {
            return arr_2;
        }
        if (n == 0) {
            return arr_1;
        }
        while (i < m && j < n) {
            if (arr_1[i] < arr_2[j]) {
                res[k++] = arr_1[i++];
            } else {
                res[k++] = arr_2[j++];
            }
        }
        while (i < m) {
            res[k++] = arr_1[i++];
        }
        while (j < n) {
            res[k++] = arr_2[j++];
        }
        return res;
    }
}