import java.util.LinkedList;
import java.util.Queue;

public class BuildTree {
    public static void main(String[] args) {
        BuildTree obj = new BuildTree();
        int[] preorder = { 3, 9, 20, 15, 7 };
        int[] inorder = { 9, 3, 15, 20, 7 };
        obj.buildTree(preorder, inorder);

    }

    
    Queue<Integer> queue = new LinkedList<Integer>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode root = new TreeNode();;
        root.val = preorder[0];
        // queue.add(root.val);
        int n = inorder.length;
        if (n == 1) {
            return root;
        }
        int index = findIndex(inorder, preorder[0]);
        // seperate inorder
        int[] inorderL = new int[index];
        int[] inorderR = new int[n - index - 1];
        for (int i = 0; i < index; i++) {
            inorderL[i] = inorder[i];
        }
        for (int i = index + 1; i < n; i++) {
            inorderR[i - index - 1] = inorder[i];
        }
        // seperate preorder
        int[] preorderL = new int[index];
        int[] preorderR = new int[n - index - 1];
        int l = 0, r = 0;
        for (int i = 1; i < n; i++) {
            int idxR = findIndex(inorderR, preorder[i]);
            int idxL = findIndex(inorderL, preorder[i]);
            if (idxR != -1) {
                preorderR[r++] = preorder[i];
            }
            if (idxL != -1) {
                preorderL[l++] = preorder[i];
            }
        }
        buildTree(preorderL, inorderL);
        buildTree(preorderR, inorderR);
        return root;
    }

    public int findIndex(int[] inorder, int target) {
        for(int i = 0; i < inorder.length; i++){
            if(target == inorder[i]){
                return i;
            }
        }
        return -1;
    }
}