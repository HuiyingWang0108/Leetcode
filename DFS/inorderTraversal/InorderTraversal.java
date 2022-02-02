import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class InorderTraversal {
    public static void main(String[] args) {

    }

    // List<Integer> res = new ArrayList<Integer>();

    public List<Integer> inorderTraversal(TreeNode root) {
        /**
         * leetcode 94
         * InorderTraversal: L -> Root -> R
         * pseudocode: recursive
         * step0, let global variable res = new ArrayList<Integer>()
         * step1, according to inorder traversal the root
         * step2, if (root is null)
         * then return res
         * step3, let L = root.left, R = root.right
         * step4, if ( L is null)
         * then res.add(root.val)
         * inorderTraversal(R)
         * step5, if (R is null)
         * then inorderTraversal(L)
         * res.add(root.val)
         * step6, if ( L and R are both not null)
         * then inorderTraversal(L)
         * res.add(root.val)
         * inorderTraversal(R)
         * step7, return res
         * step8, quit
         * 
         * 
         */
        // if(root == null){
        // return res;
        // }
        // if(root.left == null && root.right == null){
        // res.add(root.val);
        // return res;
        // }
        // TreeNode R = root.right;
        // TreeNode L = root.left;
        // if(L == null){
        // res.add(root.val);
        // inorderTraversal(R);
        // }
        // if(R == null){
        // inorderTraversal(L);
        // res.add(root.val);

        // }
        // if(L != null && R != null){
        // inorderTraversal(L);
        // res.add(root.val);
        // inorderTraversal(R);
        // }
        // return res;

        // --------------Follow up: Recursive solution is trivial, could you do it
        // iteratively?-------------not
        // good!!!---------------------------------------------

        /**
         * iteratively
         * step0, let global variable res = new ArrayList<Integer>()
         * step1, according to inorder traversal the root
         * step2, if (root is null)
         * then return res
         * -----------------left node stack--------------------------
         * step3, let L = root.left, R = root.right
         * step4, let stack to save the left nodes of the root
         * step5, while (L is not null) do
         * stack.push(L)
         * L = L.left
         * end
         * step6, while (stack is not empty) dp
         * let left = stack.pop()
         * res.add(left.val)
         * let left_R = left.right
         * if (left_R is not null)
         * then according to inorder traversal the left_R
         * --------------middle node---------------------
         * step7, res.add(root.val)
         * ---------------right node queue---------------------------
         * step8, let queue to save right nodes of the root
         * step9, while (R is not null) do
         * queue.add(R)
         * R = R.right
         * end
         * step10, while (queue is not empty) do
         * let right = queue.poll()
         * let right_L = right.right
         * if (right_L is not null)
         * then according to inorder traversal the right_L
         * res.add(right.val)
         * end
         * step11, return res
         * step12, quit
         * 
         */
        // if (root == null) {
        // return res;
        // }
        // if (root.left == null && root.right == null) {
        // res.add(root.val);
        // return res;
        // }
        // TreeNode R = root.right;
        // TreeNode L = root.left;

        // Stack<TreeNode> stack = new Stack<TreeNode>();
        // while(L != null){
        // stack.push(L);
        // L = L.left;
        // }
        // while(!stack.isEmpty()){
        // TreeNode l = stack.pop();
        // TreeNode l_R = l.right;
        // res.add(l.val);
        // if(l_R != null){
        // inorderTraversal(l_R);
        // }
        // }

        // res.add(root.val);

        // Queue<TreeNode> quenue = new LinkedList<TreeNode>();
        // while(R != null){
        // quenue.add(R);
        // R = R.right;
        // }
        // while(!quenue.isEmpty()){
        // TreeNode r = quenue.poll();
        // TreeNode r_L = r.left;
        // if(r_L != null){
        // inorderTraversal(r_L);
        // }
        // res.add(r.val);
        // }

        // return res;
        /**
         * ---------iterator------L -> Root -> R---------------------
         * step1, inorder traversal to the root
         * step2, let res = new ArrayList
         * step3, let stack = new stack
         * step4, while (root != null || stack is not empty) do
         *           while (root != null) do
         *               stack.push(root)
         *               root = root.left
         *           end
         *           root = stack.pop()
         *           res.add(root.val)   
         *           root = roor.right
         *        end
         * step5, return res
         * step6, quit
         */
        List<Integer> res = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while(root != null || !stack.isEmpty()){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            res.add(root.val);
            root = root.right;            
        }

        return res;
    }
}