import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreorderTraversal {
    public static void main(String[] args) {
        PreorderTraversal obj = new PreorderTraversal();
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode();
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        obj.preorderTraversal(root);

    }

    // List<Integer> res = new ArrayList<Integer>();

    public List<Integer> preorderTraversal(TreeNode root) {
        /**
         * ---------recursive----------------
         */
        // if (root == null) {
        // return res;
        // }
        // TreeNode L = root.left;
        // TreeNode R = root.right;
        // res.add(root.val);
        // if (L == null && R == null) {
        // return res;
        // }
        // if (L == null) {
        // preorderTraversal(R);
        // }
        // if (R == null) {
        // preorderTraversal(L);
        // }
        // if (L != null && R != null) {
        // preorderTraversal(L);
        // preorderTraversal(R);
        // }
        // return res;
        /**
         * --------------------iterator not goog way---------------
         */
        // if (root == null) {
        // return res;
        // }
        // TreeNode L = root.left;
        // TreeNode R = root.right;
        // res.add(root.val);

        // if (L == null && R == null) {
        // return res;
        // }

        // Queue<TreeNode> queue_l = new LinkedList<TreeNode>();

        // while (L != null) {
        // queue_l.add(L);
        // L = L.left;
        // }
        // if(!queue_l.isEmpty()) {
        // TreeNode l = queue_l.poll();
        // TreeNode l_R = l.right;
        // TreeNode l_L = l.left;
        // res.add(l.val);
        // if(l_L != null){
        // preorderTraversal(l_L);
        // }
        // if (l_R != null) {
        // preorderTraversal(l_R);
        // }
        // }

        // Queue<TreeNode> queue_r = new LinkedList<TreeNode>();
        // while (R != null) {
        // queue_r.add(R);
        // R = R.right;
        // }
        // if(!queue_r.isEmpty()) {
        // TreeNode r = queue_r.poll();
        // res.add(r.val);
        // TreeNode r_L = r.left;
        // TreeNode r_R = r.right;
        // if (r_L != null) {
        // preorderTraversal(r_L);
        // }
        // if(r_R != null){
        // preorderTraversal(r_R);
        // }
        // }
        // return res;
        /**
         * ---------iterator: Root -> L -> R---------------
         * step1, preorder traversal to the root
         * step2, let res = new ArrayList
         * step3, let stack = new stack
         * step4, if (root is not null) 
         *           then stack.push(root)
         *           while (stack is not empty) do
         *               let r = stack.pop()
         *               res.add(r.val)
         *               let L = r.left, R = r.right
         *               if (R is not null)
         *                  then stack.push(R)
         *               if (L is not null)
         *                  then stack.push(L)
         *           end
         * step5, return res
         * step6, quit
         *          
         * 
         */
        List<Integer> res = new ArrayList<Integer>();
        if (root == null) {
            return res;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode r = stack.pop();
            res.add(r.val);
            TreeNode L = r.left;
            TreeNode R = r.right;
            if(R != null){
                stack.push(R);
            }
            if(L != null){
                stack.push(L);
            }
        }
        return res;
    }
}