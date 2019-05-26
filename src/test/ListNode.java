package test;


public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        String str = "index:" + val;
        if (next != null) {
            str += "->" + next.toString();
        }
        return str;
    }
}
