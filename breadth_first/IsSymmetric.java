public class IsSymmetric {
    public static void main(String[] args) {
        IsSymmetric obj = new IsSymmetric();
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(3);
        root.right = new TreeNode(3);
        root.left.left = null;
        root.left.right = new TreeNode(47);
        root.left.right.left = new TreeNode(-7);
        root.left.right.right = null;
        root.right.left = new TreeNode(80);
        root.right.left.left = null;
        root.right.left.right = new TreeNode(-7);
        root.right.right = null;
        obj.isSymmetric(root);

    }

    public boolean isSymmetric(TreeNode root) {
        // The number of nodes in the tree is in the range [1, 1000].
        if (root.left == null && root.right == null) {
            return true;
        }
        if (root.left == null) {
            return false;
        }
        if (root.right == null) {
            return false;
        }
        return isRoot(root.left, root.right);
    }

    /**
     * 
     * @param left
     * @param right
     */
    private boolean isRoot(TreeNode left, TreeNode right) {
        if (left.val != right.val) {
            return false;
        }
        if ((left.left == null && right.right == null) && (left.right == null && right.left == null)) {
            if (left.val == right.val) {
                return true;
            }
        }
        if (left.left == null && right.right == null) {
            return isRoot(left.right, right.left);
        }
        if (left.right == null && right.left == null) {
            return isRoot(left.left, right.right);
        }
        if ((left.left == null && right.right != null) || (left.right == null && right.left != null)
                || (left.left != null && right.right == null) || (left.right != null && right.left == null)) {
            return false;
        }
        return isRoot(left.right, right.left) && isRoot(left.left, right.right);

    }
}