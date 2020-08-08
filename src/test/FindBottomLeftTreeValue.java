package test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 找树左下角的值
 * @author LeiDongxing
 * create on 2020/8/8 15:22
 */
public class FindBottomLeftTreeValue {
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        //从右向左的层序遍历
        TreeNode node = root;
        while (!queue.isEmpty()) {
            for (int i = 0; i < queue.size(); i++) {
                node = queue.peek();
                queue.poll();

                if (node.right != null) {
                    queue.offer(node.right);
                }

                if (node.left != null) {
                    queue.offer(node.left);
                }
            }
        }
        return node.val;
    }

    public static void main(String[] args) {
        FindBottomLeftTreeValue ds = new FindBottomLeftTreeValue();
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        System.out.println(ds.findBottomLeftValue(root));

    }
}
