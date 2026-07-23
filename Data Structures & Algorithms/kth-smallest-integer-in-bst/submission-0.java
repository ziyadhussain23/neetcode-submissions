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
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> ls = new ArrayList<>();
        helper(root, ls);
        return ls.get(k - 1);
    }

    private void helper(TreeNode node, List<Integer> ls){
        if(node == null) return;

        helper(node.left, ls);
        ls.add(node.val);
        helper(node.right, ls);
    }
}
