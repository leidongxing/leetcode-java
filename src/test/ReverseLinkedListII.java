package test;

/**
 * @author LeiDongxing
 * created on 2021/3/18
 * 反转链表 II
 */
public class ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        //哨兵节点
        ListNode sentinel = new ListNode(-1);
        sentinel.next = head;

        //找到 left right中间节点和两头节点
        ListNode pre = sentinel;
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }
        ListNode leftNode = pre.next;

        ListNode rightNode = pre;
        for (int i = 0; i < right - left + 1; i++) {
            rightNode = rightNode.next;
        }


        ListNode curr = rightNode.next;
        //断链
        pre.next = null;
        rightNode.next = null;

        //反转
        reverseLinkedList(leftNode);

        pre.next = rightNode;
        leftNode.next = curr;
        return sentinel.next;
    }

    /**
     * 头插法
     */
    private void reverseLinkedList(ListNode head) {
        //记录头节点
        ListNode pre = null;
        ListNode cur = head;

        while (cur != null) {
            //记录当前节点的后续节点
            ListNode next = cur.next;

            //把当前节点 插到头节点上
            cur.next = pre;

            //当前节点成为新的头节点
            pre = cur;

            //再次迭代
            cur = next;
        }
    }
}
