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
class Tuple{
    TreeNode node;
    int v,level;
    public Tuple(TreeNode node,int v,int level){
        this.node=node;
        this.v=v;
        this.level=level;
    }
}
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;
    Queue<Tuple> q=new LinkedList<>();
    //v->level->{nodes}
    TreeMap<Integer, TreeMap<Integer, List<Integer>>> map = new TreeMap<>();
    q.add(new Tuple(root,0,0));

    while(!q.isEmpty()){
      //  List<Integer> arr=new ArrayList<>();
        Tuple t = q.poll();
        TreeNode node=t.node;
        int v = t.v;
        int level=t.level;

        if(!map.containsKey(v))
        map.put(v,new TreeMap<>());

        if(!map.get(v).containsKey(level))
        map.get(v).put(level,new ArrayList<>());

        map.get(v).get(level).add(node.val);

        if(node.left != null){
            q.add(new Tuple(node.left,v-1,level+1));
        }
        if(node.right != null){
            q.add(new Tuple(node.right,v+1,level+1));
        }

        
    }


for (TreeMap<Integer, List<Integer>> sub : map.values()) {
            List<Integer> column = new ArrayList<>();

            for (List<Integer> list : sub.values()) {
                Collections.sort(list);   // important
                column.addAll(list);
            }

            ans.add(column);
        }
    return ans;
    }
}