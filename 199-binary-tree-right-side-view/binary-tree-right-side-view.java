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
 class Pair{
    int level;
    TreeNode node;
    public Pair(int level,TreeNode node){
        this.level=level;
        this.node=node;
    }
 }
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans=new ArrayList<>();
        if(root == null) return ans;
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(0,root));
        
        while(!q.isEmpty()){
            Pair p=q.poll();
            int level=p.level;
            TreeNode node=p.node;

            if(level == ans.size())
            ans.add(node.val);

            if(node.right != null)
            q.add(new Pair(level+1,node.right));

            if(node.left != null)
            q.add(new Pair(level+1,node.left));
        }

        return ans;
    }
}