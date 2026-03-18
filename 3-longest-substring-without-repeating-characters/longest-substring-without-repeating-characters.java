class Solution {
    public int lengthOfLongestSubstring(String s) {
        int start=0,end=0;
        int n=s.length();
        HashMap<Character,Integer> map=new HashMap<>();
        int maxLen=0;

        while(end < n){
            map.put(s.charAt(end),map.getOrDefault(s.charAt(end),0)+1);

            if(map.get(s.charAt(end)) > 1){
                while(map.get(s.charAt(end)) > 1 ){
                    map.put(s.charAt(start),map.get(s.charAt(start))-1);
                    start++;
                }
            }
            int len = end - start + 1;
            maxLen=Math.max(len,maxLen);

            end++;

        }

        return maxLen;
    }
}