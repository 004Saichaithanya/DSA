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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        ArrayList<Integer> arr1 = new ArrayList<>();
        ArrayList<Integer> arr2 = new ArrayList<>();

        inorder(root1, arr1);
        inorder(root2, arr2);

        // for(int x: arr1)
        // System.out.print(x+" ");

        return arr1.equals(arr2);

    }

    void inorder(TreeNode root, ArrayList<Integer> arr) {
        if (root == null)
            return;

        inorder(root.left, arr);
        if (root.left == null && root.right == null)
            arr.add(root.val);
        inorder(root.right, arr);
    }
}