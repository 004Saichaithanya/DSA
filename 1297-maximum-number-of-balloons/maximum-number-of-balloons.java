class Solution {
    public int maxNumberOfBalloons(String text) {
        int[] hash = new int[26];

        for (char ch : text.toCharArray()) {
            hash[ch - 'a']++;
        }

        char[] ans = new char[] { 'b', 'a', 'l', 'o', 'n' };

        int minCnt = Integer.MAX_VALUE;
        for (char ch : ans) {
            if(ch == 'l' || ch == 'o') 
                hash[ch - 'a'] /= 2;   
    
            minCnt = Math.min(minCnt, hash[ch - 'a']);
        }

        return minCnt;
    }
}