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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode h1 = new ListNode(0, head);
        ListNode node = h1;

        while(true){
            ListNode k1 = kth(node, k);
            if(k1 == null) break;

            ListNode n1 = k1.next;
            
            ListNode prev = k1.next;
            ListNode cur = node.next;

            while(cur != n1){
                ListNode next = cur.next;
                cur.next = prev;
                prev = cur;
                cur = next;
            }

            ListNode next = node.next;
            node.next = k1;
            node = next;

        }
        return h1.next;
    }

    private ListNode kth(ListNode cur, int k){
        while(cur != null && k > 0){
            cur = cur.next;
            k--;
        }
        return cur;
    }

    
}
