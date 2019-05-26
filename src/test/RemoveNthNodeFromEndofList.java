package test;

import java.util.HashMap;
import java.util.Map;


public class RemoveNthNodeFromEndofList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
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

    //	public ListNode removeNthFromEnd(ListNode head, int n) {
//	    ListNode start = new ListNode(0);
//	    ListNode slow = start, fast = start;
//	    slow.next = head;
//	    
//	    //Move fast in front so that the gap between slow and fast becomes n
//	    for(int i=1; i<=n+1; i++)   {
//	        fast = fast.next;
//	    }
//	    //Move fast to the end, maintaining the gap
//	    while(fast != null) {
//	        slow = slow.next;
//	        fast = fast.next;
//	    }
//	    //Skip the desired node
//	    slow.next = slow.next.next;
//	    return start.next;
//	}
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode next1 = new ListNode(2);
        ListNode next2 = new ListNode(3);
        head.next = next1;
        next1.next = next2;
        new RemoveNthNodeFromEndofList().removeNthFromEnd(head, 3);
    }
}
 