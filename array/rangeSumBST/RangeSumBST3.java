
public class RangeSumBST3{
    public static void main(String[] args) {
        RangeSumBST3 obj = new RangeSumBST3();
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
        if(root == null){
            return 0;
        }
        int val = 0, left = 0, right = 0;
        if(root.val <= high && root.val >= low){
            val = root.val;
        }
        if(root.val > low){
            left = rangeSumBST(root.left, low, high);
        }
        if(root.val < high){
            right = rangeSumBST(root.right, low, high);
        }
        return val + left + right;
        
    }
}