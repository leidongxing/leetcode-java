package test;

public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
//		if (head == null || head.next == null) {
//			return head;
//		}
//
//		ListNode temp1 = head;
//		ListNode temp2 = head.next;
//
//		ListNode start = temp2;
//		ListNode swapNext = temp2.next;
//		start.next = temp1;
//		temp1.next = swapNext;
//
//		ListNode swapHead = temp1;
//		temp1 = temp1.next;
//		if(temp1!=null){
//			temp2 = temp1.next;	
//		}
//		while (temp1 != null && temp2 != null) {
//			swapNext = temp2.next;
//			temp1.next = swapNext;
//			temp2.next = temp1;
//			swapHead.next = temp2;
//
//			swapHead = temp1;
//			temp1 = temp1.next;
//			if (temp1 == null) {
//				break;
//			}
//			temp2 = temp1.next;
//		}
//		return start;

//		if ((head == null)||(head.next == null)){
//			  return head;
//		}
//		          
//	    ListNode n = head.next;
//	    head.next = swapPairs(head.next.next);
//	    n.next = head;
//	    return n;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode current = dummy;
        while (current.next != null && current.next.next != null) {
            ListNode first = current.next;
            ListNode second = current.next.next;
            first.next = second.next;
            current.next = second;
            current.next.next = first;
            current = current.next.next;
        }
        return dummy.next;


    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode next1 = new ListNode(2);
        ListNode next2 = new ListNode(3);
        ListNode next3 = new ListNode(4);
        ListNode next4 = new ListNode(5);
        head.next = next1;
        next1.next = next2;
        next2.next = next3;
        next3.next = next4;
        System.out.println(new SwapNodesInPairs().swapPairs(head));
    }
}
