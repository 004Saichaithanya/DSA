class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        String temp = "";
        int maxLen = 0;

        for (int i = 0; i < n; i++) {
            //odd length
            int l = i, r = i;
            while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
                if ((r - l + 1 > maxLen)) {
                    temp = s.substring(l, r + 1);
                    maxLen = r - l + 1;
                }
                l--;
                r++;
            }
            //even length;
            l = i;
            r = i + 1;
            while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
                if ((r - l + 1 > maxLen)) {
                    temp = s.substring(l, r + 1);
                    maxLen = r - l + 1;
                }
                l--;
                r++;
            }

        }

        return temp;
    }
}