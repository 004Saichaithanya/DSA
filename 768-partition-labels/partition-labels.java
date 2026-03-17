class Solution {
    public List<Integer> partitionLabels(String s) {
        int start=0;
        int end=0;
        int n=s.length();
        HashMap<Character,Integer> map=new HashMap<>();

        for(int i=0;i<n;i++){
            map.put(s.charAt(i),i);
        }
        List<Integer> ans=new ArrayList<>();


        for(int i=0;i<n;i++){
            end = Math.max(end,map.get(s.charAt(i))); // each char far possible last occur
            if(i == end){
                ans.add(end - start + 1);
                start=i+1; // next partition
            }
        }

        return ans;
    }
}