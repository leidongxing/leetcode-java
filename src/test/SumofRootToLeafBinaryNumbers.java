package test;

import java.util.*;

public class SumofRootToLeafBinaryNumbers {

    //    public int sumRootToLeaf(TreeNode root) {
//        if(root==null){
//            return 0;
//        }
//        int sum=0;
//        int index=0;
//        int currentIndex=0;
//        Queue<TreeNode> queue = new LinkedList<TreeNode>();
//        Queue<Integer> weight = new LinkedList<Integer>();
//        HashMap<TreeNode,Integer> node2depth = new HashMap<TreeNode,Integer>();
//        queue.add(root);
//        weight.add(index);
//        while(!queue.isEmpty()){
//            TreeNode current =queue.poll();
//            currentIndex = weight.poll();
//            node2depth.put(current,currentIndex);
//            if (current.left != null) {
//                queue.add(current.left);
//                weight.add(currentIndex+1);
//            }
//            if (current.right != null) {
//                queue.add(current.right);
//                weight.add(currentIndex + 1);
//            }
//        }
//        for(Map.Entry<TreeNode,Integer> e:node2depth.entrySet()){
//             sum+=e.getKey().val*(currentIndex-e.getValue());
//        }
//        return  sum;
//    }
    public int sumRootToLeaf(TreeNode root) {
        return dfs(root, 0);
    }

    int dfs(TreeNode root, int pre) {
        if (root == null) {
            return 0;
        } else {
            int cur = pre * 2 + root.val;
            if (root.left == null && root.right == null) {
                return cur;
            } else {
                return dfs(root.left, cur) + dfs(root.right, cur);
            }
        }
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(0);
        TreeNode right = new TreeNode(1);
        root.left = left;
        root.right = right;
        left.left = new TreeNode(0);
        left.right = new TreeNode(1);
        right.left = new TreeNode(0);
        right.right = new TreeNode(1);
        SumofRootToLeafBinaryNumbers srtlfbn = new SumofRootToLeafBinaryNumbers();
        System.out.println(srtlfbn.sumRootToLeaf(root));
    }
}
