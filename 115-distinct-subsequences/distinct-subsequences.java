class Solution {
    private int dfs(int i, int j, String s, String t, int[][] dp){
        if(j>=t.length())return 1;

        if(i>=s.length())return 0;
        if(dp[i][j]!=-1)    return dp[i][j];
        int ans =0;
        if(s.charAt(i)==t.charAt(j)){
            ans +=dfs(i+1, j+1, s, t, dp); 
        }
        ans += dfs(i+1, j, s, t, dp);
        
        return dp[i][j]= ans;
    }
    public int numDistinct(String s, String t) {
        int[][] dp = new int[s.length()][t.length()];
        for(int[] d1: dp){
            Arrays.fill(d1, -1);
        }
        return dfs(0,0, s, t, dp);
    }
}