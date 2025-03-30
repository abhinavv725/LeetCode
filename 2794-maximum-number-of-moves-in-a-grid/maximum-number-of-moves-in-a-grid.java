class Solution {
    private boolean isvalid(int i, int j, int n, int m){
        return i>=0 && j>=0 && i<n && j<m;
    }
    int[] dx = {-1, 0, 1};
    int[] dy = {1, 1, 1};
    private int dfs(int[][] grid, int i, int j, int n, int m){
        
        int ans = 0;
        for(int t=0;t<=2;t++){
            int nr = i+dx[t];
            int nc = j+dy[t];
            if(isvalid(nr, nc, n,m) && grid[nr][nc]>grid[i][j]){
                ans= Math.max(ans, 1+ dfs(grid, nr,nc, n,m));
            }
        }
        return ans;
        
    }
    private int tab(int[][] grid){
        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[n][m];
        for(int i=0;i<grid.length;i++){
            dp[i][0] = 1;
        }
        for(int j=m-2;j>=0;j--){
            for(int i=0;i<n;i++){
                int ans=0;
                for(int t=0;t<=2;t++){
                    int nr = i+dx[t];
                    int nc = j+dy[t];
                    if(isvalid(nr, nc, n,m) && grid[nr][nc]>grid[i][j]){
                        ans= Math.max(ans, 1+ dp[nr][nc]);
                    }
                }
                dp[i][j]=ans;
            }

        }
        int ans=0;
        for(int i=0;i<n;i++){
            ans= Math.max(ans, dp[i][0]);
        }

        return ans;
   }
    public int maxMoves(int[][] grid) {
        // int ans=0;
        // for(int i=0;i<grid.length;i++){
        //     ans = Math.max(ans, dfs(grid, i, 0, grid.length, grid[0].length));
        // }
        // return ans;
        return tab(grid);
    }
}