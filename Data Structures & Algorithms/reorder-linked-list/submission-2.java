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
    public void reorderList(ListNode head) {
        ListNode slow = head, fast = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            if(fast != null && fast.next != null) slow = slow.next;
        }
        //System.out.println(slow.val + " " + fast);
        ListNode slow2 = slow;
        slow = slow.next;
        slow2.next = null;
        ListNode prev = null, cur = slow, next = null;
        while(cur != null){
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        //System.out.println(prev.val);
        ListNode l1 = head, l2 = prev;
        while(l1 != null && l2 != null){
            ListNode n1 = l1.next, n2 = l2.next;
            l1.next = l2;
            if(n1 != null) l2.next = n1;
            l2 = n2;
            l1 = n1;
        }
        //if(l2 != nul ) l1.next = l2;
        
    }
}
