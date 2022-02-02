import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class PostorderTraversal {
    public static void main(String[] args) {
        PostorderTraversal obj = new PostorderTraversal();
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode();
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        obj.postorderTraversal(root);
    }

    List<Integer> res = new ArrayList<Integer>();

    public List<Integer> postorderTraversal(TreeNode root) {
        /**
         * iterator:
         * * ---------iterator: L -> R -> Root---------------
         * step1, postorder traversal to the root
         * step2, let res = new LinkList
         * step3, let stack = new stack
         * step4, if (root is not null)
         * then stack.push(root)
         * while (stack is not empty) do
         * let r = stack.pop()
         * res.addFirst(r.val)
         * if (r.left is not null)
         * then stack.push(r.left)
         * if (r.right is not null)
         * then stack.push(r.right)
         * end
         * step5, return res
         * step6, quit
         */
        // LinkedList<Integer> list = new LinkedList<>();
        // Stack<TreeNode> stack = new Stack<>();
        // if (root == null) {
        // return list;
        // }
        // stack.add(root);
        // while (!stack.isEmpty()) {
        // TreeNode node = stack.pop();
        // list.addFirst(node.val);
        // if (node.left != null) {
        // stack.add(node.left);
        // }
        // if (node.right != null) {
        // stack.add(node.right);
        // }
        // }
        // return list;
        /**
         * ------------recursive-------------------------
         */

        // LinkedList<Integer> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        TreeNode L = root.left;
        TreeNode R = root.right;
        if (L == null && R == null) {
            res.add(root.val);
            return res;
        }
        if (L == null) {
            postorderTraversal(R);
            res.add(root.val);
        }
        if (R == null) {
            postorderTraversal(L);
            res.add(root.val);
        }
        if(L != null && R != null){
            postorderTraversal(L);
            postorderTraversal(R);
            res.add(root.val);
        }
        return res;
    }
}