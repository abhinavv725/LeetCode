class Solution {
    public int f(int i, int j,int[][] obstacleGrid,int[][] dp){
        if(i==0 && j==0)return 1;
        if(i < 0 || j  < 0 || obstacleGrid[i][j]==1)return 0;
        
        if(dp[i][j]!=-1)return dp[i][j];
        
        return dp[i][j]=f(i-1,j,obstacleGrid,dp) + f(i,j-1,obstacleGrid,dp);
    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int i = obstacleGrid.length;
        int j = obstacleGrid[0].length;
        if(obstacleGrid[0][0]==1 || obstacleGrid[i-1][j-1]==1)return 0;
        int[][] dp = new int[i][j];
        for(int[] row: dp)Arrays.fill(row,-1);
        return f(i-1,j-1,obstacleGrid,dp);
    }
}