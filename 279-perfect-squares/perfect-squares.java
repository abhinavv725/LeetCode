class Solution {
    int res = Integer.MAX_VALUE;
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, res);
        dp[0]=0;
        for(int i=1;i<=n;i++){
            for(int s=1;s<=i;s++){
                int square = s*s;
                if(square>i)
                    break;
                dp[i] = Math.min(dp[i], 1+dp[i-square]);
            }
        }

        return dp[n];
    }
}