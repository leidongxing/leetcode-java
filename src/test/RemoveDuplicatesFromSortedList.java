package test;

/**
 * @author LeiDongxing
 * created on 2021/2/6
 * 删除排序链表中的重复元素
 */
public class RemoveDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        int preVal = head.val;
        ListNode result = head;
        while (head.next != null) {
            int val = head.next.val;
            if (preVal == val) {
                ListNode tmp = head.next.next;
                head.next.next = null;
                head.next = tmp;
            } else {
                preVal = val;
                head = head.next;
            }
        }
        return result;
    }
}
