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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int len = 0;
        ListNode node = head;
        while(node != null){
            len++;
            node = node.next;
        }
        int pos = len - n - 1;
        if(pos == -1) return head.next;
        node = head;
        for(int i = 0; i < pos; i++){
            node = node.next;
        }
        node.next = node.next.next;
        return head;
    }
}
