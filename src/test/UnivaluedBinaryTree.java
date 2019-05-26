package test;

public class UnivaluedBinaryTree {
    public boolean isUnivalTree(TreeNode root) {
        if (root.left == null && root.right == null) {
            return true;
        } else if (root.left != null && root.right != null) {
            if (root.val == root.left.val && root.val == root.right.val) {
                return isUnivalTree(root.left) && isUnivalTree(root.right);
            } else {
                return false;
            }
        } else if (root.left == null) {
            if (root.val == root.right.val) {
                return isUnivalTree(root.right);
            }
            return false;

        } else {
            if (root.val == root.left.val) {
                return isUnivalTree(root.left);
            } else {
                return false;
            }
        }
    }

    public static void main(String[] args) {
        UnivaluedBinaryTree univaluedBinaryTree = new UnivaluedBinaryTree();
        TreeNode root = new TreeNode(2);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(2);
        left.left = new TreeNode(5);
        left.right = new TreeNode(2);
        root.left = left;
        root.right = right;
        System.out.println(univaluedBinaryTree.isUnivalTree(root));
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        return super.toString() + "___" + String.valueOf(val);
    }
}