public class SumRootToLeaf {
    public static void main(String[] args) {
        SumRootToLeaf obj = new SumRootToLeaf();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(1);
        obj.sumRootToLeaf(root);

    }

    public int sumRootToLeaf(TreeNode root) {
        return dfs(root, 0);
    }
    private int dfs(TreeNode root, int val) {
        if(root == null){
            return 0;
        }
        val = (val << 1) + root.val;
        TreeNode l = root.left;
        TreeNode r = root.right;
        if(l == null && r == null){
            return val;
        }
        return dfs(l, val) + dfs(r, val);

    }
}