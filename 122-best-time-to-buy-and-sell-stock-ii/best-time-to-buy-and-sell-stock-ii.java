class Solution {
    private int check(int[] prices, int i, boolean buy){
        if(i==prices.length)
            return 0;
        if(buy){
            return Math.max(-prices[i] + check(prices, i+1, false),
                 0+ check(prices, i+1, true));

        }else{
            return Math.max(prices[i]+ check(prices, i+1, true), 0+check(prices, i+1, false));
        }
    }
    private int tab(int[] prices){
        int n=prices.length;
        int[][] dp= new int[n+1][2];
        dp[n][0]=dp[n][1]=0;

        for(int i=n-1;i>=0;i--){
            for(int buy=0;buy<=1;buy++){
                if(buy==1){
                    dp[i][buy]= Math.max(-prices[i] + dp[i+1][0], 0+ dp[i+1][1]);

                }else{
                    dp[i][buy]= Math.max(prices[i]+ dp[i+1][1], 0+dp[i+1][0]);
                }
            }
        }
        return dp[0][1];

    }
    public int maxProfit(int[] prices) {
        return tab(prices);
    }
}