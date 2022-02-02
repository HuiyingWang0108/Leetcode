
public class RangeSumBST2 {
    public static void main(String[] args) {
        RangeSumBST2 obj = new RangeSumBST2();
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

    int rangeSum;

    public int rangeSumBST(TreeNode root, int low, int high) {
        /**
         * iteration from root to left and right
         * if tree's node val is between low and hight then add it 
         * 
         */
        rangeSum = 0;
        diggerTree(root, low, high);
        return rangeSum;
        
    }

    private void diggerTree(TreeNode root, int low, int high) {
        if(root == null){
            return;
        }
        if(root.val >= low && root.val <= high){
            rangeSum += root.val;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        diggerTree(left, low, high);
        diggerTree(right, low, high);
    }
}