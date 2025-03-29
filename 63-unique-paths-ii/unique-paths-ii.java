class Solution {
    private int check(int[][] obstacleGrid, int i, int j, int n, int m){
        if(i==n-1 && j==m-1 && obstacleGrid[i][j]!=1 )
            return 1;
        if(i==n || j==m || obstacleGrid[i][j]==1)
            return 0;
        return check(obstacleGrid, i+1, j, n,m )+
                check(obstacleGrid, i, j+1, n,m);
    }
    private int dp(int[][] grid){
        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[n][m];
        for(int i=0;i<n;i++){
            if(grid[i][0]==1)
                break;
            dp[i][0]=1;
        }
        for(int i=0;i<m;i++){
            if(grid[0][i]==1)
                break;
            dp[0][i]=1;
        }
        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                if(grid[i][j]==1)
                    dp[i][j]=0;
                else{
                    dp[i][j]=dp[i-1][j]+dp[i][j-1];
                }
            }
        }
        return dp[n-1][m-1];
    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        return dp(obstacleGrid);
    }
}