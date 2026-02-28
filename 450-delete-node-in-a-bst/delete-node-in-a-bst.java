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
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return null;
        if(root.left == null && root.right == null){
            if(root.val == key) 
            return null;
        }
        TreeNode prev=null;
        TreeNode cur = root;
        while(cur != null){
            if(cur.val > key){
            prev=cur;
            cur=cur.left;
            }
            else if(cur.val < key){
            prev=cur;
            cur=cur.right;
            }
            else{
                if(cur.left == null && cur.right ==null){
                    if(prev != null){
                        if(prev.left == cur)
                        prev.left=null;
                        else
                        prev.right=null;
                    }
                }else if(cur.left == null && cur.right != null){
                    if(prev != null){
                    if(prev.left == cur)
                    prev.left=cur.right;
                    else
                    prev.right=cur.right;
                    }else{
                        root=root.right;
                    }
                }else if(cur.left != null && cur.right == null){
                    if(prev != null){
                    if(prev.left == cur)
                    prev.left=cur.left;
                    else
                    prev.right=cur.left; 
                    }else{
                        root=root.left;
                    }
                }
                else{
                    TreeNode leftNode=cur.left;

                    while(leftNode.right !=null)
                    leftNode=leftNode.right;

                    cur.val = leftNode.val;
                    
                    cur.left=deleteNode(cur.left,leftNode.val);

                }
                 break;
            }
        }

        return root;
    }
}