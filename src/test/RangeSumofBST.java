package test;

/**
 * 二叉搜索树的范围和
 */
public class RangeSumofBST {
    //	 private int sum =0;
//	 public int rangeSumBST(TreeNode root, int L, int R) {
//	     if(root!=null ) {
//	    	 if(root.val>=L && root.val<=R) {
//	    		 sum+=root.val; 
//	    	 }
//	    	 rangeSumBST(root.left,L,R);
//	    	 rangeSumBST(root.right,L,R);
//	     }
//	     
//		 return sum;
//	 }

    /**
     * 返回值位于 low high之间的所有结点的值的和
     */
    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }
        if (root.val < low) {
            return rangeSumBST(root.right, low, high);
        }
        if (root.val > high) {
            return rangeSumBST(root.left, low, high);
        }
        return root.val + rangeSumBST(root.right, low, high) + rangeSumBST(root.left, low, high);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        TreeNode left = new TreeNode(5);
        TreeNode right = new TreeNode(15);
        root.left = left;
        root.right = right;
        left.left = new TreeNode(3);
        left.right = new TreeNode(7);
        right.right = new TreeNode(18);
        RangeSumofBST r = new RangeSumofBST();
        System.out.println(r.rangeSumBST(root, 7, 15));
    }
}
