public class CountNodesDfs {
    public static void main(String[] args) {
        CountNodesDfs obj = new CountNodesDfs();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        obj.countNodes(root);
    }
    int c = 0;
    public int countNodes(TreeNode root) {
        /**
         * recursive
         * time: O(n)
         * space: O(logn)
         */
        // if(root == null){
        //     return 0;
        // }
        // TreeNode l = root.left;
        // TreeNode r = root.right;
        // //base case
        // if(l == null && r == null){
        //     return 1; 
        // }
        // int c_l = countNodes(l);
        // int c_r = countNodes(r);
        // return c_l + c_r + 1;
        if(root == null){
            return 0;
        }
        c++;
        dfs(root);
        return c;
    }

    public void dfs(TreeNode root) {
        if(root == null){
            return;
        }
        TreeNode l = root.left;
        TreeNode r = root.right;
        dfs(l);
        dfs(r);
    }
}