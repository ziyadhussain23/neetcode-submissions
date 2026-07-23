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
    // int pre;
    // Map<Integer, Integer> hm;
    // public TreeNode buildTree(int[] preorder, int[] inorder) {
    //     pre = 0;
    //     hm = new HashMap<>();

    //     for(int i = 0; i < inorder.length; i++){
    //         hm.put(inorder[i], i);
    //     }

    //     return helper(preorder, 0, inorder.length - 1);
    // }


    // private TreeNode helper(int[] preorder, int l, int r){
    //     if(l > r) return null;
    //     int val = preorder[pre++];
    //     TreeNode root = new TreeNode(val);
    //     int mid = hm.get(val);
    //     root.left = helper(preorder, l, mid - 1);
    //     root.right = helper(preorder, mid + 1, r);
    //     return root;
    // }

    int pre, in;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        pre = 0;
        in = 0;
        return helper(preorder, inorder, Integer.MAX_VALUE);
    }

    private TreeNode helper(int[] preorder, int[] inorder, int limit){
        if(pre >= preorder.length) return null;
        if(inorder[in] == limit){
            in++;
            return null;
        }

        TreeNode root = new TreeNode(preorder[pre++]);
        root.left = helper(preorder, inorder, root.val);
        root.right = helper(preorder, inorder, limit);
        return root;
    }
}
