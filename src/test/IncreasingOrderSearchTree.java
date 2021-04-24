package test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LeiDongxing
 * created on 2021/4/25
 * 递增顺序搜索树
 */
public class IncreasingOrderSearchTree {
    public TreeNode increasingBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inOrder(list, root);
        if (list.isEmpty()) {
            return null;
        }
        TreeNode result = new TreeNode(list.get(0));
        TreeNode p = result;
        for (int i = 1; i < list.size(); i++) {
            result.left = null;
            result.right = new TreeNode(list.get(i));
            result = result.right;
        }
        return p;
    }

    private void inOrder(List<Integer> list, TreeNode node) {
        if (node != null) {
            inOrder(list, node.left);
            list.add(node.val);
            inOrder(list, node.right);
        }
    }
}
