package test;

/**
 * @author LeiDongxing
 * created on 2021/11/18
 * 二叉树的坡度
 */
public class BinaryTreeTilt {
    /**
     * 整个树的坡度就是其所有节点的坡度之和。
     *
     * @return 该节点左子树的节点之和和右子树节点之和的差的绝对值 。如果没有左子树的话，左子树的节点之和为0；没有右子树的话也是一样。空结点的坡度是0
     */
    public int findTilt(TreeNode root) {
        result = 0;
        postOrder(root);
        return result;
    }

    private int result;

    private int postOrder(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = postOrder(node.left);
        int right = postOrder(node.right);
        result += Math.abs(left - right);
        return node.val + left+ right;
    }

}
