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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int inLen=inorder.length;
        int postLen=postorder.length;

        for(int i=0;i<inLen;i++)
        map.put(inorder[i],i);

        return buildTree(postorder,postLen-1,0,
                        inorder,0,inLen-1,map);
    }
    TreeNode buildTree(int[] postorder,int postEnd,int postStart,
                        int[] inorder,int inStart,int inEnd,HashMap<Integer,Integer> map){
        if(postEnd < 0 || postStart > postEnd   || inStart > inEnd ) return null;

        TreeNode root = new TreeNode(postorder[postEnd]);
        int inRoot = map.get(root.val);
        int numLeft = inRoot - inStart;

        root.left = buildTree(postorder,postStart+numLeft-1,postStart,
                                inorder,inStart,inRoot-1,map);

        root.right = buildTree(postorder,postEnd - 1,postStart + numLeft ,
                                inorder,inRoot+1,inEnd ,map);

        return root;
    }
}