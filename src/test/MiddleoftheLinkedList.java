package test;

import java.util.ArrayList;
import java.util.List;

public class MiddleoftheLinkedList {
//	public ListNode middleNode(ListNode head) {
//        List<ListNode> al = new ArrayList<ListNode>(); 
//		while(head!=null) {
//        	al.add(head);
//        	head=head.next;
//        }
//		return al.get(al.size()/2);
//	}
//	

    /**
     * 快慢指针法
     *
     * @param head
     * @return
     */
    public ListNode middleNode(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        MiddleoftheLinkedList t = new MiddleoftheLinkedList();
        t.middleNode(new ListNode(2));
    }
}
