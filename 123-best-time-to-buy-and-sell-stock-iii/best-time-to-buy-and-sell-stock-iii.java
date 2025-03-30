class Solution {
    private int check(int[] prices, int i, int cap, int buy){
        if(cap<0)
            return -(int) Math.pow(10, 9);
        if(i==prices.length)
            return 0;
        if(buy==1){
            return Math.max(-prices[i]+check(prices, i+1, cap, 0),
                            0 + check(prices, i+1, cap, 1));
        }else{
            return Math.max(prices[i] + check(prices, i+1, cap-1, 1),
                            0 + check(prices, i+1, cap, 0));
        }

    }
    private int tab(int[] prices){
        int n=prices.length;
        int[][][] dp = new int[n+1][2][3];
        
        for(int i=n-1;i>=0;i--){
            for(int buy = 0;buy<=1;buy++){
                for(int cap=1;cap<=2;cap++){
                    if(buy==1){
                        dp[i][buy][cap]= Math.max(-prices[i]+dp[i+1][0][cap],
                                        0 + dp[i+1][1][cap]);
                    }else{
                        dp[i][buy][cap] = Math.max(prices[i] +dp[i+1][1][cap-1], 
                                                0+ dp[i+1][0][cap]);
                        
                    }
                }
            }
        }
        return dp[0][1][2];

    }
    public int maxProfit(int[] prices) {
        return tab(prices);
    }
}