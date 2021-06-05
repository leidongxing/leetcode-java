package test;

/**
 * @author LeiDongxing
 * created on 2021/6/5
 * 移除链表元素
 */
public class RemoveLinkedListElements {
    //删除链表中所有满足Node.val==val的节点，并返回新的头节点
    public ListNode removeElements1(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        ListNode p1 = new ListNode(-1);
        ListNode p2 = p1;
        p1.next = head;
        while (p1.next != null) {
            if (p1.next.val == val) {
                ListNode tmp = p1.next.next;
                p1.next = null;
                p1.next = tmp;
            } else {
                p1 = p1.next;
            }
        }
        return p2.next;
    }

    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return head;
        }
        head.next = removeElements(head.next, val);
        return head.val == val ? head.next : head;
    }

}
