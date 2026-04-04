class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int[] dp=new int[n];

        dp[n-1] = prices[n-1];
        int maxProfit=0;

        for(int i=n-2;i>=0;i--){
            dp[i] = Math.max(prices[i] , dp[i+1]);
            maxProfit = Math.max(maxProfit, dp[i+1] - prices[i]);
        }
        
        return maxProfit;
    }
}