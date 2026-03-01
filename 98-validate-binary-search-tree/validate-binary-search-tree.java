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
    public boolean isValidBST(TreeNode root) {
        if(root.left == null && root.right == null) return true;
        long min=Long.MIN_VALUE;
        long max=Long.MAX_VALUE;
               // System.out.println(max);
       return isValidBST(root,min,max); 
    }
    boolean isValidBST(TreeNode root,long min,long max){
        if(root == null) return true;

        if(min < root.val && max > root.val){
            boolean b1= isValidBST(root.left,min,root.val);
            boolean b2= isValidBST(root.right,root.val,max);
            return b1 && b2;
        }else 
        return false;
        

    }
}