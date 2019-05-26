package test;

import java.util.Stack;

public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        Stack<Integer> s = new Stack<Integer>();
        int prev = -1;
        boolean isOdd = false;
        if (head == null || head.next == null) {
            return true;
        }
        while (head != null) {
            if (s.empty()) {
                s.push(head.val);
                prev = head.val;
            } else {
                if (s.peek() == head.val) {
                    s.pop();
                } else if (prev == head.val) {
                    isOdd = true;
                    s.pop();

                } else {
                    prev = s.peek();
                    s.push(head.val);
                }
            }
            head = head.next;
        }
        return s.empty() || (isOdd == true && s.size() == 1);
    }


    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l12 = new ListNode(0);
        ListNode l13 = new ListNode(1);
        ListNode l14 = new ListNode(1);
//		ListNode l2 = new ListNode(5);
        l1.next = l12;
        l12.next = l13;
        l13.next = l14;
//		l14.next=l2;
        PalindromeLinkedList s = new PalindromeLinkedList();
        System.out.println(s.isPalindrome(l1));
    }

}
