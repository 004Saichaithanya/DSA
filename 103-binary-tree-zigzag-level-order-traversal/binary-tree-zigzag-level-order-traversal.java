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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> main = new ArrayList<>();
        int flag = 0;
        if (root == null)
            return main;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> sub = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                // if(flag % 2 == 0){
                if (node.left != null)
                    q.add(node.left);
                if (node.right != null)
                    q.add(node.right);
                // }else{
                //     if(node.right != null) q.add(node.right);
                //     if(node.left != null) q.add(node.left);                   
                // }
                sub.add(node.val);
            }
            if (flag % 2 == 0)
                main.add(sub);
            else {
                Collections.reverse(sub);
                main.add(sub);
            }
            flag++;

        }

        return main;
    }
}