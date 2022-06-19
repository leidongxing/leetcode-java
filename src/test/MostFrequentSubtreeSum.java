package test;

import java.util.*;

/**
 * @author LeiDongxing
 * created on 2022/6/19
 * 出现次数最多的子树元素和
 */
public class MostFrequentSubtreeSum {
    public int[] findFrequentTreeSum(TreeNode root) {
        Map<Integer, Integer> sum2Count = new HashMap<>();
        dfs(root, sum2Count);
        int max = sum2Count.entrySet().stream().max(Comparator.comparingInt(Map.Entry::getValue)).get().getValue();

        List<Integer> result = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : sum2Count.entrySet()) {
            if (entry.getValue() == max) {
                result.add(entry.getKey());
            }
        }
        int[] s = new int[result.size()];
        for (int i = 0; i < s.length; i++) {
            s[i] = result.get(i);
        }
        return s;
    }

    private int dfs(TreeNode root, Map<Integer, Integer> sum2Count) {
        if (root == null) {
            return 0;
        }
        int val = root.val;
        if (root.left == null && root.right == null) {
            sum2Count.put(val, sum2Count.getOrDefault(val, 0) + 1);
            return root.val;
        } else if (root.left != null && root.right != null) {
            int lVal = dfs(root.left, sum2Count);
            int rVal = dfs(root.right, sum2Count);
            int sumVal = val + lVal + rVal;
            sum2Count.put(sumVal, sum2Count.getOrDefault(sumVal, 0) + 1);
            return sumVal;
        } else if (root.left == null) {
            int rVal = dfs(root.right, sum2Count);
            int sumVal = val + rVal;
            sum2Count.put(sumVal, sum2Count.getOrDefault(sumVal, 0) + 1);
            return sumVal;
        } else {
            int lVal = dfs(root.left, sum2Count);
            int sumVal = val + lVal;
            sum2Count.put(sumVal, sum2Count.getOrDefault(sumVal, 0) + 1);
            return sumVal;
        }
    }

    public static void main(String[] args) {
        MostFrequentSubtreeSum m = new MostFrequentSubtreeSum();
        TreeNode root = new TreeNode(5);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(-5);
//        left.left = new TreeNode(5);
//        left.right = new TreeNode(2);
        root.left = left;
        root.right = right;
        System.out.println(Arrays.toString(m.findFrequentTreeSum(root)));
    }
}
