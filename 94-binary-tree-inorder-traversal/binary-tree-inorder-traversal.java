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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans=new ArrayList<>();
        TreeNode cur=root;
        while(cur != null){
            if(cur.left == null){
                ans.add(cur.val);
                cur=cur.right;
            }
            else if(cur.left != null){
                TreeNode rightMost=cur.left;
                while(rightMost.right != null && rightMost.right != cur) 
                rightMost=rightMost.right;

                if(rightMost.right == null){
                rightMost.right=cur;
                cur=cur.left;
                }
                else{
                    rightMost.right=null;
                    ans.add(cur.val);
                    cur=cur.right;
                }
            }

        }

        return ans;
    }
}