package test;

public class MergeTwoBinaryTrees {

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 != null && t2 != null) {
            t1.val = t1.val + t2.val;
            t1.left = mergeTrees(t1.left, t2.left);
            t1.right = mergeTrees(t1.right, t2.right);
        } else if (t1 == null) {
            t1 = t2;
        } else {
            t1 = t1;
        }
        return t1;
    }

    public static void main(String[] args) {
        MergeTwoBinaryTrees m = new MergeTwoBinaryTrees();
        TreeNode t1 = new TreeNode(1);
        TreeNode t1l = new TreeNode(3);
        TreeNode t1r = new TreeNode(2);
        TreeNode t1ll = new TreeNode(5);
        t1.left = t1l;
        t1.right = t1r;
        t1l.left = t1ll;

        TreeNode t2 = new TreeNode(2);
        TreeNode t2l = new TreeNode(1);
        TreeNode t2r = new TreeNode(3);
        TreeNode t2lr = new TreeNode(4);
        TreeNode t2rr = new TreeNode(7);
        t2.left = t2l;
        t2.right = t2r;
        t2l.right = t2lr;
        t2r.right = t2rr;

        t1 = m.mergeTrees(t1, t2);
        System.out.println(t1);

    }
}


