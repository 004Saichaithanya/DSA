class Solution {
    public int countGoodSubstrings(String s) {
        HashSet<Character> set=new HashSet<>();
        int n=s.length();
        int start=0,end=0;
        int cnt=0;

        while(start < n){
            while(end - start < 3 && end < n &&  !set.contains(s.charAt(end))){
                set.add(s.charAt(end));
                end++;
            }
            if(end - start  == 3){
                cnt++;
                set.remove(s.charAt(start));
                start++;
            }else{
            set.remove(s.charAt(start));
                start++;
            }
        }

        return cnt;


    }
}