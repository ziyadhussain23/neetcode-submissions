/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    // public List<Integer> rightSideView(TreeNode root) {
    //     List<Integer> res = new ArrayList<>();
    //     if(root == null) return res;
    //     Queue<TreeNode> q = new LinkedList<>();
    //     q.add(root);
    //     while(!q.isEmpty()){
    //         int size = q.size();
            
    //         for(int i = 0; i < size; i++){
    //             TreeNode t = q.poll();
    //             if(i == size - 1) res.add(t.val);
    //             if(t.left != null) q.add(t.left);
    //             if(t.right != null) q.add(t.right);
    //         }
            
    //     }
    //     return res;
    // }

    List<Integer> res;
    public List<Integer> rightSideView(TreeNode root) {
        res = new ArrayList<>();
        helper(root, 0);
        return res;
    }

    public void helper(TreeNode node, int h){
        if(node == null) return;

        if(h == res.size()) res.add(node.val);

        helper(node.right, h + 1);
        helper(node.left, h + 1);
    }
}
