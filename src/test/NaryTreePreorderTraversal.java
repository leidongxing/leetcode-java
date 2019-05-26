package test;

import java.util.LinkedList;
import java.util.List;

public class NaryTreePreorderTraversal {
    List<Integer> li = new LinkedList<Integer>();

    public List<Integer> preorder(Node root) {
        if (root != null) {
            li.add(root.val);
            for (int i = 0; i < root.children.size(); i++) {
                if (root.children.get(i).children != null) {
                    preorder(root.children.get(i));
                }
            }
        }
        return li;
    }

    public static void main(String[] args) {

    }

}

class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
