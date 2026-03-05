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

    public BSTIterator(TreeNode root,boolean isReverse) {
        stk = new Stack<>();
        if(isReverse == true)
        goLeft(root);
        else
        goRight(root);
    }

    public void goLeft(TreeNode root) {
        while (root != null) {
            stk.push(root);
            root = root.left;
        }
    }

    public int next() {
        TreeNode node = null;
        if (!stk.isEmpty()) {
            node = stk.pop();
            if (node.right != null)
                goLeft(node.right);
        }
        return node.val;
    }

        public void goRight(TreeNode root) {
        while (root != null) {
            stk.push(root);
            root = root.right;
        }
    }

    public int before() {
        TreeNode node = null;
        if (!stk.isEmpty()) {
            node = stk.pop();
            if (node.left != null)
                goRight(node.left);
        }
        return node.val;
    }

}



// class BSTIteratorNext {

//     Stack<TreeNode> stk;

//     public BSTIteratorNext(TreeNode root) {
//         stk = new Stack<>();
//         goLeft(root);
//     }

//     public void goLeft(TreeNode root) {
//         while (root != null) {
//             stk.push(root);
//             root = root.left;
//         }
//     }

//     public int next() {
//         TreeNode node = null;
//         if (!stk.isEmpty()) {
//             node = stk.pop();
//             if (node.right != null)
//                 goLeft(node.right);
//         }
//         return node.val;
//     }

    

// }

// class BSTIteratorBefore {

//     Stack<TreeNode> stk;

//     public BSTIteratorBefore(TreeNode root) {
//         stk = new Stack<>();
//         goRight(root);
//     }

//     public void goRight(TreeNode root) {
//         while (root != null) {
//             stk.push(root);
//             root = root.right;
//         }
//     }

//     public int before() {
//         TreeNode node = null;
//         if (!stk.isEmpty()) {
//             node = stk.pop();
//             if (node.left != null)
//                 goRight(node.left);
//         }
//         return node.val;
//     }

// }

class Solution {
    public boolean findTarget(TreeNode root, int k) {
        BSTIterator nextObj = new BSTIterator(root,true);
        BSTIterator beforeObj = new BSTIterator(root,false);

        int i = nextObj.next();
        int j = beforeObj.before();

        while (i < j) {
            if (i + j > k)
                j = beforeObj.before();
            else if (i + j < k)
                i = nextObj.next();
            else
                return true;
        }

        return false;

    }
}