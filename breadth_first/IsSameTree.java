public class IsSameTree {
    public static void main(String[] args) {

    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null) {
            return false;
        }
        if (q == null) {
            return false;
        }
        if(p.val != q.val){
            return false;
        }else{
            TreeNode left_p = p.left;
            TreeNode left_q = q.left;
            boolean left_b = isSameTree(left_p, left_q);
            TreeNode right_p = p.right;
            TreeNode right_q = q.right;
            boolean right_b = isSameTree(right_p, right_q);
            if(left_b && right_b){
                return true;
            }
        }
        return false;

    }
}