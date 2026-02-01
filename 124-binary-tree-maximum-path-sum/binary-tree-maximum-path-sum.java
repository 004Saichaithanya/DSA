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
    int maxi=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        int ans = findHt(root);
        return maxi;
    }
    int findHt(TreeNode root){
        if(root == null) return 0;

        int lSum = findHt(root.left);
        int rSum = findHt(root.right);

        if(lSum < 0) lSum=0;
        if(rSum < 0) rSum=0;

        maxi = Math.max(maxi ,lSum+rSum+root.val);

        return root.val + Math.max(lSum,rSum);
    }
}