class Solution {
    private int dfs(int i, int[] prices, int buy, int k,int[][][] dp){
        if(k<=0)
            return 0;
        if(i==prices.length){
            if(buy==0){
                return +prices[i-1];
            }
            return 0;
        }
        if(dp[i][buy][k]!=-1)
            return dp[i][buy][k];
        int ans=0;
        if(buy==1){
            ans = Math.max(-prices[i] + dfs(i+1, prices, 0, k, dp), 
                            0 + dfs(i+1, prices, 1, k, dp));

        }else{
            ans = Math.max(+prices[i] + dfs(i+1, prices, 1, k-1, dp), 
                            0 + dfs(i+1, prices, 0, k, dp));
        }
        return dp[i][buy][k] = ans;

    }
    public int maxProfit(int[] prices) {
        int[][][] dp = new int[prices.length][2][3];
        for(int[][] row1: dp){
            for(int[] row2: row1){
                Arrays.fill(row2, -1);
            }
        }
        return dfs(0, prices, 1, 2, dp);
    }
}