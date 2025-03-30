class Solution {
    private int check(int[] prices, int i, int buy){
        if(i>=prices.length)
            return 0;
        if(buy==1){
            return Math.max(-prices[i] + check(prices, i+1, 0), 
                            0 + check(prices, i+1, 1));
        }else{
            return Math.max(prices[i] + check(prices, i+2, 1),
                            0 + check(prices, i+1, 0));
        }

    }
    private int tab(int[] prices){
        int n=prices.length;
        int[][] dp = new int[n+1][2];

        for(int i=n-1;i>=0;i--){
            for(int buy=0;buy<=1;buy++){
                if(buy==1){
                    dp[i][buy]= Math.max(-prices[i] + dp[i+1][0], dp[i+1][1]);
                }else{
                    int temp = dp[i+1][0];
                    if(i+2<n){
                        temp = Math.max(temp,prices[i] + dp[i+2][1]);
                    }else{
                        temp = Math.max(temp, prices[i]);
                    }
                    dp[i][buy]= temp;
                }
            }
        }
        return dp[0][1];


    }
    public int maxProfit(int[] prices) {
        return tab(prices);
    }
}