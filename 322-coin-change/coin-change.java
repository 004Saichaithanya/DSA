class Solution {
    int minChange = Integer.MAX_VALUE;

    public int coinChange(int[] coins, int amount) {
        int n = coins.length;

        Arrays.sort(coins);

        int[][] dp = new int[n][amount + 1];

        for (int[] arr : dp)
            Arrays.fill(arr, Integer.MAX_VALUE);

        // for(int i = coins.length - 1; i >= 0; i--)
        recurFunc(0, n - 1, amount, coins, 0, dp);

        return (minChange == Integer.MAX_VALUE) ? -1 : minChange;
    }

    void recurFunc(int sum, int ind, int amt, int[] coins, int cnt, int[][] dp) {
        if (sum == amt) {
            minChange = Math.min(minChange, cnt);
            return;
        }
        if (cnt >= minChange)
            return;
        if (ind == coins.length || sum > amt)
            return;
        if (dp[ind][sum] <= cnt)
            return;
        dp[ind][sum] = cnt;

        for (int i = ind; i >= 0; i--) {
            if (sum <= amt - coins[i])
                recurFunc(sum + coins[i], i, amt, coins, cnt + 1, dp);
        }

    }
}