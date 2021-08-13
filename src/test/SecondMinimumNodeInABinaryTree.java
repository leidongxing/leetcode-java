package test;

/**
 * @author LeiDongxing
 * created on 2021/7/27
 * 二叉树中第二小的节点
 */
public class SecondMinimumNodeInABinaryTree {
    int result;
    int rootValue;

    //对于二叉树中的任意节点x，x的值不大于以x为根的子树中所有节点的值。
    //二叉树根节点的值即为所有节点中的最小值。
    public int findSecondMinimumValue(TreeNode root) {
        result = -1;
        rootValue = root.val;
        dfs(root);
        return result;
    }

    private void dfs(TreeNode node) {
        if (node == null) {
            return;
        }
        if (result != -1 && node.val >= result) {
            return;
        }
        if (node.val > rootValue) {
            result = node.val;
        }
        dfs(node.left);
        dfs(node.right);
    }
}
