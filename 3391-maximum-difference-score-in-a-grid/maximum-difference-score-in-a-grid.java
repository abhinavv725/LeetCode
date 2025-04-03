class Solution {
    private int solve(int i, int j, int[][] grid, int[][] dp){
        int n=grid.length;
        int m=grid[0].length;
        
        if(dp[i][j]!=-1)
            return dp[i][j];
        
        int p = Integer.MIN_VALUE, q = Integer.MIN_VALUE, ans=0;
        if(i+1<n){
            p = Math.max(0, grid[i+1][j]-grid[i][j] + solve(i+1, j, grid, dp));
        }
        if(j+1<m){
            q = Math.max(0, grid[i][j+1]-grid[i][j] + solve(i, j+1, grid, dp));
        }
        return dp[i][j]=Math.max(ans, Math.max(p,q));
        
    }




    public int maxScore(List<List<Integer>> g) {
        
        int[][] grid = new int[g.size()][g.get(0).size()];
        int curr=-1;
        for(int i=0;i<g.size();i++){
            for(int j=0;j<g.get(0).size();j++){
                grid[i][j] = g.get(i).get(j);
                curr=Math.max(curr,g.get(i).get(j) );
            }
        }
        int n=grid.length;
        int m=grid[0].length;
        int[][] dp = new int[n][m];
        for(int[] r: dp){
            Arrays.fill(r, -1);
        }

        int ans =Integer.MIN_VALUE, p=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                ans = Math.max(ans, solve(i,j, grid, dp));
                if(i+1<n)
                    p = Math.max(p, grid[i+1][j]-grid[i][j]);
                if(j+1<m)
                    p = Math.max(p, grid[i][j+1]-grid[i][j]);
            }
        }
        return ans ==0 ? p:ans;

    }
}