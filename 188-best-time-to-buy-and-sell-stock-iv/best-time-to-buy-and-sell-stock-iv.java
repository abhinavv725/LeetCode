class Solution {

    // Recursive DFS function to calculate max profit
    // i - current day index
    // prices - array of stock prices
    // buy - 1 if we are allowed to buy, 0 if we must sell
    // k - number of transactions remaining
    // dp - memoization table
    private int dfs(int i, int[] prices, int buy, int k, int[][][] dp) {
        // Base case: no transactions left
        if (k <= 0)
            return 0;

        // Base case: reached end of the prices array
        if (i == prices.length) {
            // If last action was a "buy", simulate the selling on the last day
            if (buy == 0) {
                return +prices[i - 1]; // Add profit by selling
            }
            return 0;
        }

        // If already computed, return stored result
        if (dp[i][buy][k] != -1)
            return dp[i][buy][k];

        int ans = 0;

        if (buy == 1) {
            // Option 1: Buy at current price and move to next day
            // Option 2: Skip buying on current day
            ans = Math.max(-prices[i] + dfs(i + 1, prices, 0, k, dp), 
                            0 + dfs(i + 1, prices, 1, k, dp));
        } else {
            // Option 1: Sell at current price and reduce one transaction
            // Option 2: Skip selling on current day
            ans = Math.max(+prices[i] + dfs(i + 1, prices, 1, k - 1, dp), 
                            0 + dfs(i + 1, prices, 0, k, dp));
        }

        // Save result in dp table and return
        return dp[i][buy][k] = ans;
    }

    // Public method to calculate the maximum profit with at most 2 transactions
    public int maxProfit(int k, int[] prices) {
        // 3D DP array for memoization
        // Dimensions: days x buy/sell state x max transactions (2 + 1)
        int[][][] dp = new int[prices.length][2][k+1];

        // Initialize all values to -1 indicating uncomputed state
        for (int[][] row1 : dp) {
            for (int[] row2 : row1) {
                Arrays.fill(row2, -1);
            }
        }

        // Start from day 0, with permission to buy, and 2 transactions available
        return dfs(0, prices, 1, k, dp);
    }
}
