package test;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class MaximumDepthofN_aryTree {
//    public int maxDepth(Node root) {
//        if (root == null) {
//          return 0;
//        } else if (root.children.isEmpty()) {
//          return 1;  
//        } else {
//          List<Integer> heights = new LinkedList<>();
//          for (Node item : root.children) {
//            heights.add(maxDepth(item)); 
//          }
//          return Collections.max(heights) + 1;
//        }
//    }  

    private int max = 0;

    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        maxDepth(root, 1);
        return max;
    }

    public void maxDepth(Node node, int depth) {
        if (node == null) {
            return;
        }
        max = Math.max(max, depth);
        for (Node child : node.children) {
            maxDepth(child, depth + 1);
        }
    }

    public static void main(String[] args) {
        MaximumDepthofN_aryTree m = new MaximumDepthofN_aryTree();
        Node t1 = new Node(1, new LinkedList<Node>());
        Node t2 = new Node(2, new LinkedList<Node>());
        Node t3 = new Node(3, new LinkedList<Node>());
        Node t4 = new Node(4, new LinkedList<Node>());
        Node t5 = new Node(5, new LinkedList<Node>());
        Node t6 = new Node(6, new LinkedList<Node>());
        t1.children.add(t3);
        t1.children.add(t2);
        t1.children.add(t4);
        t3.children.add(t5);
        t3.children.add(t6);
        System.out.println(m.maxDepth(t1));
    }
}
