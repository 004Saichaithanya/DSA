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
    int maxi=0;
    public int diameterOfBinaryTree(TreeNode root) {
        int ans = findHt(root);

        return maxi;
    }
    int findHt(TreeNode root){
        if(root == null) return 0;

        int l=findHt(root.left);
        int r=findHt(root.right);
        maxi=Math.max(maxi,l+r);

        return 1+Math.max(l,r);
    }
}