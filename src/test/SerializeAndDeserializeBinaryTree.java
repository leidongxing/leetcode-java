package test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author LeiDongxing
 * create on 2020/6/16 23:30
 * 二叉树的序列化与反序列化
 */
public class SerializeAndDeserializeBinaryTree {
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder("[");
        //层次遍历 队列存储
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            //依次出队
            TreeNode cur = queue.remove();
            if (cur == null) {
                sb.append("null,");
            } else {
                sb.append(cur.val).append(",");
                queue.add(cur.left);
                queue.add(cur.right);
            }
        }
        sb.setLength(sb.length() - 1);
        sb.append("]");
        return sb.toString();
    }

    public TreeNode deserialize(String data) {
        String[] nodes = data.substring(1, data.length() - 1).split(",");
        //根节点不是null 直接加入
        TreeNode root = getNode(nodes[0]);
        Queue<TreeNode> parents = new LinkedList<>();
        TreeNode parent = root;
        boolean isLeft = true;
        for (int i = 1; i < nodes.length; i++) {
            TreeNode cur = getNode(nodes[i]);
            if (isLeft) {
                parent.left = cur;
            } else {
                parent.right = cur;
            }
            if (cur != null) {
                parents.add(cur);
            }
            isLeft = !isLeft;
            if (isLeft) {
                //左子树 把当前节点弹出
                parent = parents.poll();
            }
        }
        return root;
    }

    private TreeNode getNode(String val) {
        if ("null".equals(val)) {
            return null;
        }
        return new TreeNode(Integer.parseInt(val));
    }
}
