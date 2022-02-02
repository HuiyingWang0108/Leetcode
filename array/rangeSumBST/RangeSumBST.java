
public class RangeSumBST{
    public static void main(String[] args) {
        RangeSumBST obj = new RangeSumBST();
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(7);
        root.right.left = new TreeNode();
        root.right.right = new TreeNode(18);
        int low = 7;
        int high = 15;
        obj.rangeSumBST(root, low, high);
    }
    public int rangeSumBST(TreeNode root, int low, int high) {
        /**
         * leecode:
         * TreeNode为class 类
         * change BST root to sorted array, the length is n
         * then preSum[n + 1] is the sum from 0 to i
         */
        if(root.left == null && root.right == null){
            return root.val;
        }
        //change BST to sorted array
        int[] sortedArray = rootToSortedArray(root);
        int n = sortedArray.length;
        // int[] preSum = new int[n + 1];
        int rangeSum = 0;
        int i = 0;
        while(sortedArray[i] < low){
            i++;
        }
        if(sortedArray[i] == low){
            do{
                rangeSum += sortedArray[i];
                i++;
            }while(i < n && sortedArray[i] <= high);
            
        }

        return rangeSum;


    }
    public int[] rootToSortedArray(TreeNode root) {
        if(root == null){
            return null;
        }
        int[] left = rootToSortedArray(root.left);
        int[] right = rootToSortedArray(root.right);
        int l, r;
        if(root.left == null){
            l = 0;
        }else{
            l = left.length;
        }
        if(root.right == null){
            r = 0;
        }else{
            r = right.length;
        }
        
        int n = l + r + 1;
        int[] res = new int[n];
        if(root.left == null && root.right == null){
            res = new int[1];
            res[0] = root.val;
            return res;
        }else{
            for(int i = 0; i < l; i++){
                res[i] = left[i];
            }
            res[l] = root.val;
            for(int i = 0; i < r; i++){
                res[l + i + 1] = right[i];
            }
            return res;
        }
        
    }
}