class Solution {
    private int[] count(String s){
        int c1=0, c0=0;
        for(char c: s.toCharArray()){
            if(c=='0')
                c0++;
            else
                c1++;
        }
        return new int[] {c0, c1};
    }
    private int dfs(int i, String[] strs, int m, int n){
        if(i<0)
            return 0;
        int[] curr = count(strs[i]);
        int pick = Integer.MIN_VALUE;
        if(m>=curr[0] && n-curr[1]>=0){
            pick = 1+ dfs(i-1, strs, m-curr[0], n-curr[1]);
        }
        int notPick = dfs(i-1, strs, m,n);

        return Math.max(pick, notPick);

    }
    private int tab(String[] strs, int m, int n){
        int[][] dp = new int[m+1][n+1];
        for(String s: strs){
            int[] curr = count(s);

            for(int i=m;i>=curr[0];i--){
                for(int j=n;j>=curr[1];j--){
                    dp[i][j] = Math.max(dp[i][j], 1+dp[i-curr[0]][j-curr[1]] );
                }
            }
        }
        
        return dp[m][n];

    }
    public int findMaxForm(String[] strs, int m, int n) {
        return tab(strs, m,n);
    }
}