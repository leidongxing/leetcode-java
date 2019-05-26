package test;

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
    public int rangeSumBST(TreeNode root, int L, int R) {
        if (root == null) return 0;
        if (root.val < L) return rangeSumBST(root.right, L, R);
        if (root.val > R) return rangeSumBST(root.left, L, R);
        return root.val + rangeSumBST(root.right, L, R) + rangeSumBST(root.left, L, R);
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
