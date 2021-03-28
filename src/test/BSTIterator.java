package test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LeiDongxing
 * created on 2021/3/28
 * 二叉搜索树迭代器
 */
public class BSTIterator {
    private List<Integer> list;

    public BSTIterator(TreeNode root) {
        list = new ArrayList<>();
        inOrder(root);
    }

    private void inOrder(TreeNode node) {
        if (node != null) {
            inOrder(node.left);
            list.add(node.val);
            inOrder(node.right);
        }
    }

    public int next() {
        return list.remove(0);
    }

    public boolean hasNext() {
        return !list.isEmpty();
    }
}
