class Solution {
    public int solve(int[] coins, int amount, int ind,int[][] dp){
        if(amount==0)return 0;
        if(amount<0 || ind<0)return Integer.MAX_VALUE;
        if(dp[ind][amount]!=-1)return dp[ind][amount];
         // Two choices: exclude or include the current coin
        int exclude = solve(coins, amount, ind - 1,dp);
        int include = solve(coins, amount - coins[ind], ind,dp);
        
        // If include is valid, add 1 to account for the coin used
        if (include != Integer.MAX_VALUE) {
            include += 1;
        }
        
        // Return the minimum of the two options
        return dp[ind][amount]=Math.min(exclude, include);
    }
    public int coinChange(int[] coins, int amount) {
        int[][] dp = new int[coins.length+1][amount+1];
        for(int[] r:dp)
            Arrays.fill(r,-1);
        int result = solve(coins, amount, coins.length - 1,dp);
        
        return result == Integer.MAX_VALUE ? -1 : result;
    }
}