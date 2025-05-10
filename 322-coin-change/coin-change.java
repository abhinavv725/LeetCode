class Solution {
    private int check(int i, int[] coins, int amount, int[][] dp){
        if(amount==0)
            return 0;
        if(amount<0)
            return Integer.MAX_VALUE;
        if(dp[i][amount]!=-1)
            return dp[i][amount];
        int ans = Integer.MAX_VALUE;
        for(int j=i;j<coins.length;j++){
            int res = check(j, coins, amount-coins[j], dp);
            if(res!=Integer.MAX_VALUE)
                ans = Math.min(ans, 1+res);
        }
        return dp[i][amount]= ans;
    }
    public int coinChange(int[] coins, int amount) {
        int[][] dp = new int[coins.length][amount+1];
        for(int[] d: dp){
            Arrays.fill(d, -1);
        }
        int ans= check(0, coins, amount, dp);
        
        return ans == Integer.MAX_VALUE ? -1: ans;
    }
}