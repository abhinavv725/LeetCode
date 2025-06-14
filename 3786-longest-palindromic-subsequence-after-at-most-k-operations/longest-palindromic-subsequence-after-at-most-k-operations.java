class Solution {
    Integer[][][] dp;
    private int dfs(int l, int r, String s, int ops){
        if(ops<0)   return Integer.MIN_VALUE;
        if(l==r)    return 1;
        if(l>r) return 0;
        if(dp[l][r][ops]!=null){
            return dp[l][r][ops];
        }

        int m1 = dfs(l+1, r, s, ops);
        int m2 = dfs(l, r-1, s, ops);
        int x = Math.abs(s.charAt(l) - s.charAt(r));
        int m3 = 2+ dfs(l+1, r-1, s, ops - Math.min(x, 26-x));
        return dp[l][r][ops]= Math.max(m1, Math.max(m2, m3));
 
    }
    public int longestPalindromicSubsequence(String s, int k) {
        dp=new Integer[s.length()][s.length()][k+1];
        return dfs(0, s.length()-1, s, k);
    }
}