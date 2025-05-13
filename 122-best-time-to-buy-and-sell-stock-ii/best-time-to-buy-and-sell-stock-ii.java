class Solution {
    private int dfs(int i, int[]prices, int buy, int[][] dp){
        if(i==prices.length-1){
            if(buy==0){
                return dp[i][buy]= prices[i];
            }
            return dp[i][buy]=0;
        }
        if(dp[i][buy]!=-1)  return dp[i][buy];
        int ans=0;
        if(buy==1){
            ans+= Math.max(
                    -prices[i] + dfs(i+1, prices, 0, dp),
                    0          + dfs(i+1, prices, 1, dp)
                );
        }else{
            ans += Math.max(
                    prices[i] + dfs(i+1, prices, 1, dp),
                    0         + dfs(i+1, prices, 0, dp)
                );

        }
        return dp[i][buy]= ans;

    }
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];
        for(int[] d1: dp){
            Arrays.fill(d1, -1);
        }
        return dfs(0, prices, 1, dp);
    }
}