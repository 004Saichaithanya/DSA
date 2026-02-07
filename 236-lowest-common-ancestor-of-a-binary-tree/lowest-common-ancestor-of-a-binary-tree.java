/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return findPath(root,p,q);
    }
    TreeNode findPath(TreeNode root,TreeNode p,TreeNode q){
        if(root == null) return null;

        if(root == p) return p;
        else if(root == q) return q;

        TreeNode left=findPath(root.left,p,q);
        TreeNode right=findPath(root.right,p,q);

        if(left == null) return right;
        else if(right == null) return left;
        else return root;
    }
}