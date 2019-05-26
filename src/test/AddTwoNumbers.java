package test;

public class AddTwoNumbers {


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // return addTwoNumbers(l1, l2, 0);
        ListNode sentinel = new ListNode(0);
        ListNode d = sentinel;
        int sum = 0;
        while (l1 != null || l2 != null) {
            sum /= 10;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            d.next = new ListNode(sum % 10);
            d = d.next;
        }

        if (sum / 10 == 1) {
            d.next = new ListNode(1);
        }
        return sentinel.next;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2, int add) {
        ListNode solution = new ListNode(add);
        add = 0;
        solution.val = solution.val + l1.val + l2.val;

        if (solution.val >= 10) {
            add = solution.val / 10;
            solution.val = solution.val % 10;
        }

        if (l1.next == null && l2.next != null) {
            solution.next = addTwoNumbers(new ListNode(0), l2.next, add);
        } else if (l1.next != null && l2.next == null) {
            solution.next = addTwoNumbers(l1.next, new ListNode(0), add);
        } else if (l1.next != null && l2.next != null) {
            solution.next = addTwoNumbers(l1.next, l2.next, add);
        } else {
            if (add != 0) {
                solution.next = new ListNode(add);
            }
        }
        return solution;
    }

    public static void main(String[] args) {
        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        ListNode l1 = new ListNode(2);
        ListNode l12 = new ListNode(4);
        ListNode l13 = new ListNode(3);
        l1.next = l12;
        l12.next = l13;

        ListNode l2 = new ListNode(5);
        ListNode l22 = new ListNode(6);
        ListNode l23 = new ListNode(4);
        l2.next = l22;
        l22.next = l23;

        ListNode solution = addTwoNumbers.addTwoNumbers(l1, l2);
        System.out.println(solution);
    }
}
