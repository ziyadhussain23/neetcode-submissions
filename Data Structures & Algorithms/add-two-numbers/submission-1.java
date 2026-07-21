/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = l1, last = null;
        int c = 0;
        while(l1 != null && l2 != null){
            l1.val += l2.val + c;
            c = l1.val / 10;
            l1.val %= 10;
            if(l1.next == null) last = l1;
            l1 = l1.next;
            l2 = l2.next;
        }

        while(l1 != null){
            l1.val += c;
            c = l1.val / 10;
            l1.val %= 10;
            if(l1.next == null) last = l1;
            l1 = l1.next;
        }
        if(l2 != null) last.next = l2;
        while(l2 != null){
            l2.val += c;
            c = l2.val / 10;
            l2.val %= 10;
            if(l2.next == null) last = l2;
            l2 = l2.next;
        }
        if(c != 0){
            last.next = new ListNode(c);
        }
        
        return head;
    }


    
}
