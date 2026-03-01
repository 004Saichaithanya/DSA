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
    //int cnt=0,ele=-1;
    public int kthSmallest(TreeNode root, int k) {
       // List<Integer> arr=new ArrayList<>();
       int[] ans=new int[2];
        inOrder(root,k,ans);

        return ans[1];
    }
    void inOrder(TreeNode root,int k,int[] ans){
        if(root == null) return;

        inOrder(root.left,k,ans);
        ans[0]++;
        if(ans[0] == k) 
        ans[1]=root.val;
        inOrder(root.right,k,ans);
    }
}