package test;

public class MergekSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        ListNode start = lists[0];
        for (int i = 1; i < lists.length; i++) {
            start = mergeTwoLists(start, lists[i]);
        }

        return start;
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode temp1 = l1;
        ListNode temp2 = l2;
        ListNode result = new ListNode(0);
        ListNode start = result;
        while (temp1 != null && temp2 != null) {
            if (temp1.val < temp2.val) {
                result.next = temp1;
                result = result.next;
                temp1 = temp1.next;
            } else {
                result.next = temp2;
                result = result.next;
                temp2 = temp2.next;
            }
        }
        if (temp1 == null) {
            while (temp2 != null) {
                result.next = temp2;
                result = result.next;
                temp2 = temp2.next;
            }
        } else {
            while (temp1 != null) {
                result.next = temp1;
                result = result.next;
                temp1 = temp1.next;
            }
        }
        return start.next;
    }

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(1);
        ListNode[] ln = new ListNode[]{l1, l2};
        System.out.println(new MergekSortedLists().mergeKLists(ln));


    }
}
