class Solution {
    private void dfs(int row,int col,int[][] grid, boolean[][] vis,int[] temp){
        int n=grid.length;
        int m=grid[0].length;
        vis[row][col]=true;
        temp[0]++;
        int[] drow={-1,0,1,0};
        int[] dcol={0,1,0,-1};

        for(int i=0;i<4;i++){
            int nrow=row+drow[i];
            int ncol=col+dcol[i];
            if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && !vis[nrow][ncol] && grid[nrow][ncol]==1)
                dfs(nrow,ncol,grid,vis,temp);
        }

    }
    public int maxAreaOfIsland(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        boolean[][] vis = new boolean[n][m];
        int max_area=0;
        int[] temp={0};
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1 && !vis[i][j]){
                    dfs(i,j,grid,vis,temp);
                    max_area=Math.max(max_area,temp[0]);
                    temp[0]=0;
                }
            }
        }
        return max_area;
    }
}