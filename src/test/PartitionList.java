package test;

/**
 * @author LeiDongxing
 * created on 2021/1/3
 * 分隔链表
 */
public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        if (head == null) {
            return head;
        }
        ListNode sentinel1 = new ListNode(-1);
        ListNode sentinel2 = new ListNode(-1);
        ListNode newHead = sentinel1;
        ListNode newMid = sentinel2;
        while (head != null) {
            if (head.val < x) {
                sentinel1.next = head;
                sentinel1 = sentinel1.next;
            } else {
                sentinel2.next = head;
                sentinel2 = sentinel2.next;
            }
            ListNode tmp = head.next;
            head.next = null;
            head = tmp;
        }
        sentinel1 = newMid.next;
        return newHead.next;
    }
}
