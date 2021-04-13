package test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LeiDongxing
 * created on 2021/4/13
 * 二叉搜索树节点最小距离
 */
public class MinimumDistanceBetweenBSTNodes {
    public int minDiffInBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inOrder(root, list);
        if (list.isEmpty() || list.size() == 1) {
            return 0;
        } else {
            int min = Integer.MAX_VALUE;
            for (int i = 1; i < list.size(); i++) {
                min = Math.min(min, list.get(i) - list.get(i - 1));
            }
            return min;
        }
    }

    private void inOrder(TreeNode node, List<Integer> list) {
        if (node != null) {
            inOrder(node.left, list);
            list.add(node.val);
            inOrder(node.right, list);
        }
    }
}
