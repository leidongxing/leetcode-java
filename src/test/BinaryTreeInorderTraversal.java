package test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author LeiDongxing
 * created on 2021/1/19
 * 中序遍历  左根右
 */
public class BinaryTreeInorderTraversal {
    public List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        search(root, result);
        return result;
    }

    private void search(TreeNode root, List<Integer> list) {
        if (root != null) {
            search(root.left, list);
            list.add(root.val);
            search(root.right, list);
        }
    }

    /**
     * 使用栈 进行中序遍历
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            result.add(root.val);
            root = root.right;
        }
        return result;
    }
}
