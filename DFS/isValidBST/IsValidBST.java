import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class IsValidBST {
    public static void main(String[] args) {

    }

    public boolean IsValidBST(TreeNode root) {
        /**
         * Time Complexity: O()
         * 
         */
        // Inorder: L -> Root -> R
        if (root == null) {
            return true;
        }
        List<Integer> list = inOrderTraverse(root);
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) >= list.get(i + 1)) {
                return false;
            }
        }
        return true;
    }

    public static List<Integer> inOrderTraverse(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) {
            return res;
        }
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            TreeNode node = stack.pop();
            res.add(node.val);
            root = node.right;
        }
        return res;
    }
}