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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) return null;
        for(int i = 1; i < lists.length; i++){
            if(lists[0] != null && lists[i] != null && lists[0].val <= lists[i].val) 
                lists[0] = merge(lists[0], lists[i]);
            else if(lists[0] != null && lists[i] != null && lists[0].val > lists[i].val)
                lists[0] = merge(lists[i], lists[0]);
        }
        return lists[0];
    }


    private ListNode merge(ListNode l1, ListNode l2){
        ListNode head = l1;
        while(l1.next != null && l2 != null){
            if(l1.next.val <= l2.val) l1 = l1.next;
            else{
                ListNode n1 = l1.next, n2 = l2.next;
                l1.next = l2;
                l2.next = n1;
                l2 = n2;
            }
        }
        

        if(l2 != null) l1.next = l2;
        //print(head);
        return head;

    }

    private void print(ListNode n){
        System.out.print("[ ");
        while(n != null){
            System.out.print(n.val + ", ");
            n = n.next;
        }
        System.out.println("]");
    }
}
