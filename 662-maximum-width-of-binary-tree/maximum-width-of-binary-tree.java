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
    TreeNode node;
    int idx;
    public Pair(TreeNode node,int idx){
        this.node=node;
        this.idx=idx;
    }
}
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
     Queue<Pair> q=new LinkedList<>();   
     q.add(new Pair(root,0));
     int maxWdth=1;

     while(!q.isEmpty()){
        int size=q.size();
        int first=0,last=0;
        int minInd = q.peek().idx;
        for(int i=0;i<size;i++){
            Pair p = q.poll();
            TreeNode node=p.node;
            int idx = p.idx - minInd;

            if(node.left != null){
                q.add(new Pair(node.left,(2*idx) + 1));
            }
            if(node.right != null){
                q.add(new Pair(node.right,(2*idx) + 2));
            }
            if(i == 0) first =idx;
            if(i == size -1) last = idx;
        }
        maxWdth=Math.max(maxWdth,(last - first) + 1);
     }

     return maxWdth;
    }
}