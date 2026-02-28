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
    public TreeNode insertIntoBST(TreeNode root, int val) {
            TreeNode newNode=new TreeNode(val);
        if(root == null) return newNode;
        TreeNode cur=root;
        while(true){
            if(cur.val < val){
            if(cur.right != null)
            cur=cur.right;
            else break;
            }
            else {
            if(cur.left != null)
            cur=cur.left;
            else
            break;
            }
        }
        if(cur.val > val)
        cur.left=newNode;
        else
        cur.right=newNode;

        return root;

    }
}