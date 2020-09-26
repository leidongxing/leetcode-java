package test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 路径总和 II
 * @author LeiDongxing
 * created on 2020/9/26
 */
public class PathSumII {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) {
            return Collections.emptyList();
        }
        List<List<Integer>> resultList = new ArrayList<>();
        search(root, 0, sum, new ArrayList<>(), resultList);
        return resultList;
    }

    private void search(TreeNode root, int current, int sum, List<Integer> currentList, List<List<Integer>> resultList) {
        current += root.val;
        currentList.add(root.val);

        //到达叶子节点 终止
        if (root.left == null && root.right == null) {
            if (current == sum) {
                resultList.add(new ArrayList<>(currentList));
            }
        } else {
            if (root.left != null) {
                search(root.left, current, sum, currentList, resultList);
            }
            if (root.right != null) {
                search(root.right, current, sum, currentList, resultList);
            }
        }

        current -= root.val;
        if (!currentList.isEmpty()) {
            currentList.remove(currentList.size() - 1);
        }
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(5);
        TreeNode t2 = new TreeNode(4);
        TreeNode t3 = new TreeNode(8);
        TreeNode t4 = new TreeNode(11);
        TreeNode t5 = new TreeNode(13);
        TreeNode t6 = new TreeNode(4);
        TreeNode t7 = new TreeNode(7);
        TreeNode t8 = new TreeNode(2);
        TreeNode t9 = new TreeNode(5);
        TreeNode t10 = new TreeNode(1);

        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t4.left = t7;
        t4.right = t8;
        t3.left = t5;
        t3.right = t6;
        t6.left = t9;
        t6.right = t10;

        PathSumII p = new PathSumII();
        System.out.println(p.pathSum(t1, 22));
    }
}



