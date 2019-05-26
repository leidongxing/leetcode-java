package test;

import java.util.LinkedList;
import java.util.List;

public class NaryTreePostorderTraversal {
    List<Integer> li = new LinkedList<Integer>();

    public List<Integer> postorder(Node root) {
        if (root != null) {
            for (int i = 0; i < root.children.size(); i++) {
                if (root.children.get(i).children != null) {
                    postorder(root.children.get(i));
                }
            }
            li.add(root.val);
        }
        return li;
    }
}
