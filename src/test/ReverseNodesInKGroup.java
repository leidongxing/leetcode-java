package test;

public class ReverseNodesInKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return head;
        }
        ListNode prev = new ListNode(0);
        prev.next = head;

        while (true) {
            head.next = head;


            break;
        }

        return prev;


    }
}
