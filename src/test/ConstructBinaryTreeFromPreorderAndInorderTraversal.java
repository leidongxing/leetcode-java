package test;

import java.util.*;

/**
 * @author LeiDongxing
 * created on 2021/2/21
 * 从前序与中序遍历序列构造二叉树
 * 树中没有重复的元素
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    /**
     * 前序遍历 根左右
     * 中序遍历 左根右
     */
    private Map<Integer, Integer> inorderIndexMap;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        inorderIndexMap = new HashMap<>();
        int n = preorder.length;
        for (int i = 0; i < n; i++) {
            inorderIndexMap.put(inorder[i], i);
        }
        return buildTree(preorder, inorder, 0, n - 1, 0, n - 1);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder, int preorderLeft, int preorderRight, int inorderLeft, int inorderRight) {
        if (preorderLeft > preorderRight) {
            return null;
        }
        //前序遍历的第一个节点就是根节点
        int preorderRoot = preorderLeft;
        int inorderRoot = inorderIndexMap.get(preorder[preorderRoot]);

        TreeNode root = new TreeNode(preorder[preorderRoot]);
        //左子树数目
        int sizeLeftTree = inorderRoot - inorderLeft;

        root.left = buildTree(preorder, inorder, preorderLeft + 1, preorderLeft + sizeLeftTree, inorderLeft, inorderRoot - 1);

        root.right = buildTree(preorder, inorder, preorderLeft + sizeLeftTree + 1, preorderRight, inorderRoot + 1, inorderRight);
        return root;
    }
}
