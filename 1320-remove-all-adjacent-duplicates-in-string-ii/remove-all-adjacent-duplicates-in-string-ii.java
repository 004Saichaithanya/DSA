class Solution {
    public String removeDuplicates(String s, int k) {
        int n=s.length();
        int[] count=new int[n];

        Stack<Character>stk=new Stack<>();

    for(char ch:s.toCharArray()){
        if(!stk.isEmpty() && stk.peek() == ch){
            stk.push(ch);
            count[stk.size()-1] = count[stk.size()-2]+1;
        }else{
            stk.push(ch);
            count[stk.size()-1]=1;
        }
        if(count[stk.size()-1] == k){
            for(int i=0;i<k;i++){
                stk.pop();
            }
        }
        
    }
       // String res="";
        StringBuilder res = new StringBuilder();

        while(!stk.isEmpty()){
            char ch =stk.peek();
            res.append(ch);
            stk.pop();
        }

        //System.out.println(res.toString());

        


        return res.reverse().toString();

        
    }
}