package test;

/**
 * @author LeiDongxing
 * create on 2020/6/21 11:24
 * 将有序数组转换为二叉搜索树
 */
public class ConvertSortedArraytoBinarySearchTree {
    int[] nums;
    private TreeNode helper(int left, int right) {
        if (left > right) {
            return null;
        }
        //找到中间位置的元素
        int p = (left + right) / 2;
        TreeNode root = new TreeNode(nums[p]);
        root.left = helper(left, p - 1);
        root.right = helper(p + 1, right);
        return root;
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        this.nums = nums;
        return helper(0, nums.length - 1);
    }


    public static void main(String[] args) {
        ConvertSortedArraytoBinarySearchTree a = new ConvertSortedArraytoBinarySearchTree();
        System.out.println(a.sortedArrayToBST(new int[]{-10,-3,0,5,9}));
    }
}
