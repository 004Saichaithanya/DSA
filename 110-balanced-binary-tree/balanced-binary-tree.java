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
    public boolean isBalanced(TreeNode root) {
        return (findHeight(root) == -1)?false:true;
    }
    int findHeight(TreeNode root){
        if(root == null) return 0;

        int l = findHeight(root.left);
        int r = findHeight(root.right);

        if(l == -1 || r == -1) return -1;

        if(Math.abs(l-r) > 1) return -1;

        return 1 + Math.max(l,r);
    }
}