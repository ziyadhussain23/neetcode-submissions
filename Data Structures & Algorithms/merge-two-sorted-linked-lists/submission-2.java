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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null && list2 == null) return null;
        else if(list1 == null) return list2;
        else if(list2 == null) return list1;
        else if(list1.val > list2.val) return mergeTwoLists(list2, list1);
       
        ListNode head = list1;
        ListNode l1 = list1;
        ListNode l2 = list2;

        while(l1.next != null && l2 != null){
            if(l1.next.val <= l2.val) l1 = l1.next;
            else{
                ListNode n2 = l2.next;
                l2.next = l1.next;
                l1.next = l2;
                l1 = l1.next;
                l2 = n2;
            }
        }
        if(l2 != null) l1.next = l2;

        return head;
    }
}