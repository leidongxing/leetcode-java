package test;

public class SearchinaBinarySearchTree {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        } else if (root.val == val) {
            return root;
        } else if (root.val > val && root.left != null) {
            return searchBST(root.left, val);
        } else if (root.val < val && root.right != null) {
            return searchBST(root.right, val);
        } else {
            return null;
        }
    }

    public static void main(String[] args) {

    }
}
