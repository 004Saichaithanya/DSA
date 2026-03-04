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
class BSTIterator {

    Stack<TreeNode> stk;

    public BSTIterator(TreeNode root) {
        stk=new Stack<>();
        goLeft(root);
    }

    public  void goLeft(TreeNode root){
        while(root != null){
            stk.push(root);
            root=root.left;
        }
        }
    
    public int next() {
        TreeNode node=null;
        if(!stk.isEmpty()){
            node=stk.pop();
            if(node.right != null)
                goLeft(node.right);
        }
        return node.val;   
    }
    
    public boolean hasNext() {
        return !stk.isEmpty();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */