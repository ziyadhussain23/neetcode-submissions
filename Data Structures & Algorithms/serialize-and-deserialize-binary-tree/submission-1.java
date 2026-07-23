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

public class Codec {
    private static final String SEP = ",";
    private static final String NULL = "#";
    private int idx;
    private String[] s;

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder str = new StringBuilder();
        helper(root, str);
        return str.toString();
    }

    private void helper(TreeNode node, StringBuilder str){
        if(node == null){
            str.append(NULL).append(SEP);
            return;
        }

        str.append(node.val).append(SEP);
        helper(node.left, str);
        helper(node.right, str);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        s = data.split(SEP);
        idx = 0;
        return helper2();
    }

    private TreeNode helper2(){
        if(idx >= s.length || s[idx].equals(NULL)){
            idx++;
            return null;
        }

        TreeNode node = new TreeNode(Integer.parseInt(s[idx++]));
        node.left = helper2();
        node.right = helper2();
        return node;
    }


    // StringBuilder str;

    // // Encodes a tree to a single string.
    // public String serialize(TreeNode root) {
    //     if(root == null) return "";
    //     str = new StringBuilder();
    //     preorder(root);
    //     str.setLength(str.length() - 1);
    //     str.append(",");
    //     inorder(root);
    //     return str.toString().trim();
    // }

    // private void preorder(TreeNode node){
    //     if(node == null) return;

    //     str.append(node.val).append(" ");
    //     preorder(node.left);
    //     preorder(node.right);
    // }


    // private void inorder(TreeNode node){
    //     if(node == null) return;

    //     inorder(node.left);
    //     str.append(node.val).append(" ");
    //     inorder(node.right);
    // }

    // // Decodes your encoded data to tree.
    // int p;
    // Map<Integer, Integer> hm;
    // public TreeNode deserialize(String data) {
    //     if(data.isEmpty()) return null;
    //     String[] s = data.split(",");
    //     String[] pre = s[0].split(" ");
    //     String[] in = s[1].split(" ");
    //     p = 0;
    //     hm = new HashMap<>();
    //     for(int i = 0; i < in.length; i++){
    //         hm.put(parse(in[i]), i);
    //     }
    //     TreeNode root = helper(pre, 0, pre.length - 1);
    //     return root;
    // }

    // private TreeNode helper(String[] pre, int l, int r){
    //     if(l > r) return null;
    //     if(p == pre.length) return null;

    //     TreeNode node = new TreeNode(parse(pre[p++]));
    //     int mid = hm.get(node.val);
    //     node.left = helper(pre, l, mid - 1);
    //     node.right = helper(pre, mid + 1, r);
    //     return node;
    // }

    // private Integer parse(String s){
    //     return Integer.parseInt(s);
    // }
}
