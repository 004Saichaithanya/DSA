class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return recurFunc(0, s, n, dp);
    }

    int recurFunc(int i, String s, int n, int[] dp) {
        if (i == n) {
            return 1;
        }
        if (s.charAt(i) == '0')
            return 0;

        if (dp[i] != -1)
            return dp[i];

        int left = 0, right = 0, range = 0;

        left = recurFunc(i + 1, s, n, dp);
        if (i + 1 < n)
            range = (s.charAt(i) - '0') * 10 + (s.charAt(i + 1) - '0');
        if (i + 1 < n && range >= 10 && range <= 26)
            right = recurFunc(i + 2, s, n, dp);

        return dp[i] = left + right;
    }
}