package com.leetcode.solutions.LinkedList;

public class AddTwoNumbers {
    
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode res = result;
        int carry = 0;
        while(l1 != null || l2 != null)
        {
            int val1 = l1 != null ? l1.val : 0;
            int val2 = l2 != null ? l2.val : 0;
            int sum  = val1 + val2 + carry;
            carry = sum / 10;
            result.next = new ListNode(sum % 10);
            result = result.next;
            if( l1 != null) l1 = l1.next;
            if( l2 != null) l2 = l2.next;
        }
        if(carry > 0 )
            result.next = new ListNode(carry);
        return res.next;
    }
    public static void main(String[] args) {
        AddTwoNumbers obj = new AddTwoNumbers();
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        ListNode result = obj.addTwoNumbers(l1, l2);

        while(result != null) {
            System.out.print(result.val);
            System.out.print(" -> ");
            result = result.next;
        }
        System.out.print(" null");
    }
}
