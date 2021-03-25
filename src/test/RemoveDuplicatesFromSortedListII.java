package test;

/**
 * @author LeiDongxing
 * created on 2021/3/25
 * 删除排序链表中的重复元素 II
 */
public class RemoveDuplicatesFromSortedListII {
    /**
     * 存在一个按升序排列的链表，给你这个链表的头节点 head ，
     * 请你删除链表中所有存在数字重复情况的节点，只保留原始链表中 没有重复出现 的数字。
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode pre = new ListNode(0, head);
        ListNode cur = pre;

        while (cur.next != null && cur.next.next != null) {
            if (cur.next.val == cur.next.next.val) {
                int x = cur.next.val;
                while (cur.next != null && cur.next.val == x) {
                    cur.next = cur.next.next;
                }
            } else {
                cur = cur.next;
            }
        }
        return pre.next;
    }
}
