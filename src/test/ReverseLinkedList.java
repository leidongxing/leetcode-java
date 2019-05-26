package test;

import java.util.Stack;

public class ReverseLinkedList {
    //stack
//    public ListNode reverseList(ListNode head) {
//    	if(head==null) {
//    		return head;
//    	}
//        Stack<ListNode> s = new Stack<ListNode>();
//        ListNode temp = null;
//        while(head!=null) {
//          temp =new ListNode(head.val);
//    	  s.push(temp);
//    	  head=head.next;    	  
//        }
//        head = s.pop();
//        temp =head;
//        while(!s.isEmpty()) {
//        	head.next=s.pop();
//        	head = head.next;
//        }
//        return temp;
//    }

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }


    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l12 = new ListNode(2);
        ListNode l13 = new ListNode(3);
        ListNode l14 = new ListNode(4);
        ListNode l2 = new ListNode(5);
        l1.next = l12;
        l12.next = l13;
        l13.next = l14;
        l14.next = l2;
        ReverseLinkedList s = new ReverseLinkedList();
        s.reverseList(l1);
    }
}
