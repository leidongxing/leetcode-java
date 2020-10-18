package test;

import java.util.HashMap;
import java.util.Map;

/**
 * 删除链表的倒数第N个节点
 */
public class RemoveNthNodeFromEndofList {
    public ListNode removeNthFromEnd2(ListNode head, int n) {
        Map<Integer, ListNode> map = new HashMap<Integer, ListNode>();
        int num = 0;
        map.put(num, head);
        ListNode current = head;
        while (current.next != null) {
            map.put(++num, current.next);
            current = current.next;
        }
        int prevIndex = map.size() - n - 1;
        if (prevIndex < 0) {
            return head.next;
        } else {
            ListNode removePrev = map.get(map.size() - n - 1);
            ListNode removeNext = map.get(map.size() - n + 1);
            removePrev.next = removeNext;
            return head;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode start = new ListNode(0);
        ListNode slow = start, fast = start;
        //保存头节点
        slow.next = head;

        for (int i = 1; i <= n + 1; i++) {
            fast = fast.next;
        }

        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        //删除倒数第n个节点
        slow.next = slow.next.next;
        return start.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode next1 = new ListNode(2);
        ListNode next2 = new ListNode(3);
        head.next = next1;
        next1.next = next2;
        new RemoveNthNodeFromEndofList().removeNthFromEnd(head, 3);
    }
}
 