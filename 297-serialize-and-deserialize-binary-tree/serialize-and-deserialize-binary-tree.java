/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 class Pair{
    String number;
    int idx;
    public Pair(String number,int idx){
        this.number=number;
        this.idx=idx;
    }
 }
public class Codec {
    StringBuilder str=new StringBuilder();
    Queue<TreeNode> q=new LinkedList<>();

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null) return "";

        q.add(root);
        while(!q.isEmpty()){
            int s=q.size();
            for(int i=0;i<s;i++){
                TreeNode node=q.poll();
                if(node == null) {
                    str.append("#,");
                }else{
                    str.append(node.val+",");
                    q.add(node.left);
                    q.add(node.right);
                }

            }
        }
    //    System.out.println(str.toString());

        return str.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.length() == 0) return null;

        int i=0;
        String rootStr="";
        while(data.charAt(i) != ','){
            rootStr+=data.charAt(i)+"";
            i++;
        }
        int num=Integer.parseInt(rootStr);
        TreeNode root=new TreeNode(num);
        q.add(root);
        
        while(!q.isEmpty()){
            TreeNode node=q.poll();
            Pair p = getNumber(data,i);
            String number=p.number;
            i=p.idx;

            if(number.equals("#")){
                node.left = null;
            }else{
                num=Integer.parseInt(number);
                node.left=new TreeNode(num);
                q.add(node.left);
            }

              p = getNumber(data,i);
            number=p.number;
            i=p.idx;

            if(number.equals("#")){
                node.right = null;
            }else{
                num=Integer.parseInt(number);
                node.right=new TreeNode(num);
                q.add(node.right);
            }
            

            
        }

        
        return root;
    }
   public Pair getNumber(String data,int idx){
    idx++;
    String number="";
    while(data.charAt(idx) != ','){
        number+=data.charAt(idx)+"";
        idx++;
    }
    Pair p =new Pair(number,idx);

    return p;
   }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));