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
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return inOrderCheck(root.left,root.right);
    }
    boolean inOrderCheck(TreeNode lNode,TreeNode rNode){
        if(lNode == null || rNode == null) return (lNode == rNode);

return (lNode.val == rNode.val ) && inOrderCheck(lNode.left,rNode.right) && inOrderCheck(lNode.right,rNode.left);

       // return false;
    }
}