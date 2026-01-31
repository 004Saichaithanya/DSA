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
        if(root == null) return ans;
        Stack<TreeNode>stk=new Stack<>();
        TreeNode node=root;
        while(node != null || !stk.isEmpty()){

            while(node != null){
                stk.push(node);
                node=node.left;
            }
            node=stk.pop();
            ans.add(node.val);
            node=node.right;

        }

        return ans;
    }
}
