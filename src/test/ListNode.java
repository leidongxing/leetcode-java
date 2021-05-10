package test;


public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
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
