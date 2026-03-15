class Solution {
    public int countSubstrings(String s) {
        int[] cnt=new int[1];
        recurFunc(0,s,cnt);
        return cnt[0];
    }
    void recurFunc(int ind,String s,int[] cnt){
        if(ind == s.length())
        return;

        for(int i=ind;i<s.length();i++){
            String palin=s.substring(ind,i+1);
            if(isPalin(palin)){
                cnt[0] += 1;
            }
        }
        recurFunc(ind+1,s,cnt);
    }
    public  boolean isPalin(String s) {
        if (s == null) return false;
        int i = 0, j = s.length() - 1;
        while (i < j) {
            char ci = s.charAt(i);
            char cj = s.charAt(j);
            if (ci != cj) return false;
            i++; j--;
        }
        return true;
    }
}