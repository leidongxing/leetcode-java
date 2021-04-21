package test;

/**
 * @author LeiDongxing
 * created on 2021/4/21
 * 二叉树的最近公共祖先
 */
public class LowestCommonAncestorOfABinaryTree {
    /**
     * p q为不同节点且一定在二叉树上
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p == root || q == root) {
            return root;
        }
        if (root != null) {
            TreeNode lNode = lowestCommonAncestor(root.left, p, q);
            TreeNode rNode = lowestCommonAncestor(root.right, p, q);
            if (lNode != null && rNode != null) {
                return root;
            } else if (lNode == null) {
                return lowestCommonAncestor(rNode, p, q);
            } else {
                return lowestCommonAncestor(lNode, p, q);
            }
        }
        return null;
    }
}
