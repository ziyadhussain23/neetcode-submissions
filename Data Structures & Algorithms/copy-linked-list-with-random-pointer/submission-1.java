/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) return null;
        Node node = new Node(head.val);
        Node n1 = head, n2 = node;
        Map<Node, Node> hm = new HashMap<>();
        hm.put(null, null);
        hm.put(n1, n2);
        while(n1.next != null){
            n1 = n1.next;
            n2.next = new Node(n1.val);
            n2 = n2.next;
            hm.put(n1, n2);
        }

        n1 = head;
        n2 = node;
        while(n1 != null){
            n2.random = hm.get(n1.random);
            n1 = n1.next;
            n2 = n2.next;
        }
        
        

        return node;
    }
}
