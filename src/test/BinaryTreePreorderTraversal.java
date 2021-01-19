package test;

import java.util.LinkedList;
import java.util.List;

/**
  * 前序遍历
 */
public class BinaryTreePreorderTraversal {
    List<Integer> li = new LinkedList<Integer>();

    public List<Integer> preorderTraversal(TreeNode root) {
        if (root != null) {
            li.add(root.val);
            preorderTraversal(root.left);
            preorderTraversal(root.right);
        }
        return li;
    }
}
