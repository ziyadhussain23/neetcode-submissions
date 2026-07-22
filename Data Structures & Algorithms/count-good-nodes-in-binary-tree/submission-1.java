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
    public int goodNodes(TreeNode root) {
        if(root == null) return 0;
        return helper(root, root.val);
    }
    
    private int helper(TreeNode node, int max){
        if(node == null) return 0;

        int cnt = node.val >= max ? 1 : 0;
        max = Math.max(max, node.val);

        return cnt + helper(node.left, max) + helper(node.right, max);
    }


}
