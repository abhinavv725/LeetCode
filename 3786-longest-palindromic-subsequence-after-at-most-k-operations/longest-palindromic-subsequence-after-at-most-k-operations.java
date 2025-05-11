class Solution {
    private int dfs(int l, int r, int operations, String s, int[][][] dp){
        if(l==r)    return 1;
        if(l>r)     return 0;
        if(dp[l][r][operations]!=-1)    return dp[l][r][operations];
        int moveL = dfs(l+1, r, operations-0, s, dp);
        int moveR = dfs(l, r-1, operations-0, s,dp);
        int convert=Integer.MIN_VALUE;
        int opsRequired = Math.min(Math.abs(s.charAt(l)-s.charAt(r)),
                                    26 - Math.abs(s.charAt(l)-s.charAt(r)));
        if(opsRequired<=operations){
            convert = 2+ dfs(l+1, r-1, operations-opsRequired, s, dp);
        }
        return dp[l][r][operations]=Math.max(moveL, Math.max(moveR, convert));
    }
    public int longestPalindromicSubsequence(String s, int k) {
        int n=s.length();
        int[][][] dp = new int[n][n][k+1];
        for(int[][] d2: dp){
            for(int[]d1: d2){
                Arrays.fill(d1, -1);
            }
        }
        return dfs(0, n-1, k, s, dp);
    }
}