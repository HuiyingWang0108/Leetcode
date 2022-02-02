import java.util.Arrays;

import javax.swing.tree.TreeNode;

public class SortedArrayToBST {
    public static void main(String[] args) {
        SortedArrayToBST obj = new SortedArrayToBST();
        int[] nums = { 10, -3, 0, 5, 9 };
        obj.sortedArrayToBST(nums);
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        /**
         * leecode:
         * TreeNode为class 类
         */
        int n = nums.length;
        if(n == 1){
            return new TreeNode(nums[0]);
        }
        if(n == 2){
           TreeNode treeNode = new TreeNode(nums[0]);
            return new TreeNode(nums[1], treeNode, null);
        }
        int mid = n / 2;
        int[] l = new int[mid], r = new int[n - mid -1];
        for(int i = 0; i < mid; i++){
            l[i] = nums[i];
        }
        // l = Arrays.copyOf(nums, mid);
        // System.out.println(Arrays.toString(l));
        
        for(int i = mid + 1; i < n; i++){
            r[i- mid -1] = nums[i];
        }
        // r = Arrays.copyOfRange(nums, mid + 1, n);
        // System.out.println(Arrays.toString(r));
        TreeNode left = sortedArrayToBST(l);
        TreeNode right = sortedArrayToBST(r);
        TreeNode treeNode = new TreeNode(nums[mid], left, right);
        return treeNode;
    }
}