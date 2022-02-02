public class CountNodesBs {
    public static void main(String[] args) {
        CountNodesBs obj = new CountNodesBs();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        // root.right.right = new TreeNode(7);
        obj.countNodes(root);
    }

    public int countNodes(TreeNode root) {
        /**
         * binary search
         * time: O(logn)
         */
        if (root == null) {
            return 0;
        }
        int lh = findLeftHeight(root);
        int rh = findRightHeight(root);
        if (lh == rh) {
            return (1 << lh) - 1;
        }
        TreeNode L = root.left;
        TreeNode R = root.right;
        return 1 + countNodes(L) + countNodes(R);

    }

    public int findLeftHeight(TreeNode root) {
        int h = 0;
        while (root != null) {
            h++;
            root = root.left;
        }
        return h;
    }

    public int findRightHeight(TreeNode root) {
        int h = 0;
        while (root != null) {
            h++;
            root = root.right;
        }
        return h;
    }
}