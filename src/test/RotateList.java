package test;

/**
 * @author LeiDongxing
 * created on 2021/2/15
 * 旋转链表  将链表每个节点向右移动k个位置
 */
public class RotateList {
    /**
     * 先将链表闭合成环 找到相应的位置再断开环
     */
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }

        ListNode oldTail = head;
        int n;
        for (n = 1; oldTail.next != null; n++) {
            oldTail = oldTail.next;
        }
        //闭合成环
        oldTail.next = head;

        ListNode newTail = head;
        for (int i = 0; i < n - k % n - 1; i++) {
            newTail = newTail.next;
        }
        ListNode newHead = newTail.next;
        newTail.next = null;
        return newHead;
    }
}
