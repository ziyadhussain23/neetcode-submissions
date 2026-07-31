/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        Map<Node, Node> hm = new HashMap<>();
        return helper(node, hm);
    }

    private Node helper(Node node, Map<Node, Node> hm){
        if(node == null) return null;

        if(hm.containsKey(node)) return hm.get(node);

        Node n = new Node(node.val);
        hm.put(node, n);

        for(Node n1 : node.neighbors){
            n.neighbors.add(helper(n1, hm));
        }
        return n;
    }
}