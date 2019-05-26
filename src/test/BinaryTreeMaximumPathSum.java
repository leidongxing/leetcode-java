package test;

public class BinaryTreeMaximumPathSum {

    private static int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        postOrder(root);
        return max;
    }

    private int postOrder(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = postOrder(root.left);
        int right = postOrder(root.right);
        int leftSum = root.val + left;
        int rightSum = root.val + right;
        int compare = Math.max(leftSum, rightSum);
        int sum = Math.max(compare, root.val);
        int total = Math.max(left + right + root.val, sum);
        max = Math.max(max, total);
        return sum;
    }

    public static void main(String[] args) {
        BinaryTreeMaximumPathSum b = new BinaryTreeMaximumPathSum();
        System.out.println(b.maxPathSum(new TreeNode(0)));
    }
}
