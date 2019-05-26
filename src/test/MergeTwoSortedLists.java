package test;


public class MergeTwoSortedLists {

//	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
//			ListNode temp1 = l1;
//			ListNode temp2 = l2;
//			ListNode result = new ListNode(0);
//			ListNode start =result;
//			while (temp1 != null && temp2 != null) {
//				if (temp1.val < temp2.val) {
//                    result.next = temp1;
//                    result = result.next;
//                    temp1 =temp1.next;
//				} else {
//					result.next = temp2;
//					result = result.next;
//					temp2 = temp2.next; 	
//				}
//			}
//			if(temp1==null){
//				while(temp2!=null){
//					result.next = temp2;
//					result = result.next;
//					temp2 = temp2.next; 		
//				}
//			}else{
//				while(temp1!=null){
//					 result.next = temp1;
//	                 result = result.next;
//	                 temp1 =temp1.next;
//				}			 
//			}
//			return start.next;
//	}

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(1);
        System.out.println(new MergeTwoSortedLists().mergeTwoLists(l1, l2));
    }
}
