import java.util.ArrayList;
import java.util.List;

public class GetAllElements {
    public static void main(String[] args) {
        GetAllElements obj = new GetAllElements();
        TreeNode root1 = new TreeNode(2);
        root1.left = new TreeNode(1);
        root1.right = new TreeNode(4);
        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(0);
        root2.right = new TreeNode(3);
        obj.getAllElements(root1, root2);
    }

    List<Integer> l = new ArrayList<Integer>();

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        /**
         * step0, let res = new ArrayList<Integer>()
         * step1, find the corner case:
         *        1> if (root1 == null && root2 == null)
         *              then return null
         *        2> if (root1 == null)
         *              then return Inordertraverse(root2)
         *        3> if (root2 == null)
         *             then return Inordertraverse(root1)
         * step2, let l1 = Inordertraverse(root1)
         *        let l2 = Inordertraverse(root2)
         * step3, merge(l1, l2)
         * 
         */
        List<Integer> res = new ArrayList<Integer>();
        if (root1 == null && root2 == null) {
            return null;
        }
        if (root1 == null) {
            return traverse(root2);
        }
        if (root2 == null) {
            return traverse(root1);
        }
        List<Integer> l1 = traverse(root1);
        l = new ArrayList<Integer>();
        List<Integer> l2 = traverse(root2);

        res = merge(l1, l2);
        return res;
    }

    public List<Integer> traverse(TreeNode root) {

        TreeNode L = root.left;
        TreeNode R = root.right;
        if (L != null) {
            traverse(L);
        }
        l.add(root.val);
        if (R != null) {
            traverse(R);
        }
        return l;
    }

    public List<Integer> merge(List<Integer> l1, List<Integer> l2) {
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