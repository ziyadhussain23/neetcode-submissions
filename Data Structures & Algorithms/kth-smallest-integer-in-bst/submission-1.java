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
    // public int kthSmallest(TreeNode root, int k) {
    //     List<Integer> ls = new ArrayList<>();
    //     helper(root, ls);
    //     return ls.get(k - 1);
    // }

    // private void helper(TreeNode node, List<Integer> ls){
    //     if(node == null) return;

    //     helper(node.left, ls);
    //     ls.add(node.val);
    //     helper(node.right, ls);
    // }


    public int kthSmallest(TreeNode root, int k) {
        int[] arr = new int[2];
        arr[0] = k;
        helper(root, arr);
        return arr[1];
    }

    private void helper(TreeNode node, int[] arr){
        if(node == null) return;

        helper(node.left, arr);
        if(arr[0] == 0) return;

        arr[0] -= 1;

        if(arr[0] == 0){
            arr[1] = node.val;
            return;
        }

        helper(node.right, arr);
    }
}
