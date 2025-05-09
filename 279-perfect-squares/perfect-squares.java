class Solution {
    private int dfs(int n, int[] dp){
        if(n<0){
            return Integer.MAX_VALUE;
        }
        if(n==0)
            return dp[n]=0;
        if(dp[n]!=-1){
            return dp[n];
        }
        int ans = Integer.MAX_VALUE;
        for(int j=1;j*j<=n;j++){
            int sub = dfs(n - (j*j),dp);
            if(sub!=Integer.MAX_VALUE)
                ans = Math.min(ans,1+ sub);
        }
        return dp[n] =ans;

    }
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        return dfs(n, dp);
        
    }
}