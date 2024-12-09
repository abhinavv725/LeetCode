class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        
        Arrays.fill(dp, Integer.MAX_VALUE);
        
        dp[0]=0;
        for(int i=1;i<=n;i++){
            
            for(int j=1;j<=i;j++){
                int square = j*j;
                
                if(i-square<0)break;
                dp[i]=Math.min(dp[i],1+dp[i-square]);
            }
            
        }
        return dp[n];
    }
}