class Solution {
    private int check(int[] prices, int i, int k, int buy){
        if(i==prices.length || k<0){
            return 0;
        }
        if(buy==1){
            return Math.max(-prices[i] + check(prices, i+1, k, 0),
                            0 + check(prices, i+1, k, 1));
        }else{
            return Math.max(prices[i]+check(prices, i+1, k-1, 1),
                            0 + check(prices, i+1, k, 0));
        }

    }
    private int tab(int[] prices, int k){
        int n=prices.length;
        int[][][] dp = new int[n+1][2][k+1];
        for(int i=n-1;i>=0;i--){
            for(int buy=0;buy<=1;buy++){
                for(int cap = 1;cap<=k;cap++){
                    if(buy==1){
                        dp[i][buy][cap]= Math.max(-prices[i] + dp[i+1][0][cap],
                                        0 + dp[i+1][1][cap]);
                    }else{
                        dp[i][buy][cap]= Math.max(prices[i]+dp[i+1][1][cap-1],
                                        0 + dp[i+1][0][cap]);
                    }
                }
            }
        }
        return dp[0][1][k];
    }
    public int maxProfit(int k, int[] prices) {
        return tab(prices, k);
    }
}