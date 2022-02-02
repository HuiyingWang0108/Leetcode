import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class GetAllElements2 {
    public static void main(String[] args) {
        GetAllElements2 obj = new GetAllElements2();
        TreeNode root1 = new TreeNode(2);
        root1.left = new TreeNode(1);
        root1.right = new TreeNode(4);
        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(0);
        root2.right = new TreeNode(3);
        obj.getAllElements(root1, root2);
    }

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        /**
         *
         *  use two stacks to inorder traverse each Binary tree
         * 
         */
        List<Integer> l1 = new ArrayList<Integer>();
        List<Integer> l2 = new ArrayList<Integer>();
        Stack<TreeNode> stack1 = new Stack<TreeNode>();
        Stack<TreeNode> stack2 = new Stack<TreeNode>();
        while(root1 != null || !stack1.isEmpty()){
            while(root1 != null){
                stack1.push(root1);
                root1 = root1.left;
            }
            TreeNode node = stack1.pop();
            l1.add(node.val);
            root1 = node.right;
        }
        while(root2 != null || !stack2.isEmpty()){
            while(root2 != null){
                stack2.push(root2);
                root2 = root2.left;
            }
            TreeNode node = stack2.pop();
            l2.add(node.val);
            root2 = node.right;
        }
       return merger(l1, l2);
    }

    public List<Integer> merger(List<Integer> l1, List<Integer> l2) {
        List<Integer> res = new ArrayList<Integer>();
        int p1 = 0, p2 = 0;
        int n1 = l1.size(), n2 = l2.size();
        while (p1 < n1 && p2 < n2) {
            if (l1.get(p1) < l2.get(p2)) {
                res.add(l1.get(p1));
                p1++;
            } else {
                res.add(l2.get(p2));
                p2++;
            }
        }
        while (p1 < n1) {
            res.add(l1.get(p1));
            p1++;
        }
        while (p2 < n2) {
            res.add(l2.get(p2));
            p2++;
        }
        return res;
    }
}