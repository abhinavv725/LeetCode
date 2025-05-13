class Solution {
    // Helper function to perform DFS with memoization
    private int dfs(int i, int[] prices, int buy, int[][] dp){
        // Base case: If we've reached the last day
        if(i == prices.length - 1) {
            // If we're not holding any stock on the last day, sell it
            if(buy == 0) {
                return dp[i][buy] = prices[i];  // Profit from selling stock at the last price
            }
            // If we're holding a stock on the last day, we can't sell it, so return 0
            return dp[i][buy] = 0;
        }

        // If we've already computed this state, return the memoized result
        if(dp[i][buy] != -1) return dp[i][buy];

        int ans = 0;

        // If we are allowed to buy (buy == 1)
        if(buy == 1) {
            // We have two choices: Buy the stock or skip (do nothing)
            ans += Math.max(
                -prices[i] + dfs(i + 1, prices, 0, dp),  // Buy the stock and move to the next day
                0 + dfs(i + 1, prices, 1, dp)            // Skip buying (stay in the same state)
            );
        } else {
            // If we are not allowed to buy (buy == 0), meaning we can sell the stock
            ans += Math.max(
                prices[i] + dfs(i + 1, prices, 1, dp),  // Sell the stock and move to the next day
                0 + dfs(i + 1, prices, 0, dp)          // Skip selling (stay in the same state)
            );
        }

        // Memoize the result for this state and return it
        return dp[i][buy] = ans;
    }

    // Main function to calculate the maximum profit
    public int maxProfit(int[] prices) {
        // Initialize the memoization table (dp array)
        int[][] dp = new int[prices.length][2];
        
        // Fill the dp array with -1, indicating uncomputed states
        for(int[] d1: dp) {
            Arrays.fill(d1, -1);
        }
        
        // Start the DFS from day 0 with the option to buy (buy == 1)
        return dfs(0, prices, 1, dp);
    }
}
