class Solution {
    
    public int f(int i, int j, int[][] grid,int[][] dp){
        if(i==0 && j==0)return grid[i][j];
        if(i<0 || j<0)return Integer.MAX_VALUE;
        if(dp[i][j]!=-1)return dp[i][j];
        return dp[i][j]=grid[i][j]+Math.min(f(i-1, j, grid,dp), f(i,j-1,grid,dp));
    }
    
    public int minPathSum(int[][] grid) {
        int i=grid.length;
        int j=grid[0].length;
        int[][] dp = new int[i][j];
        for(int[] row: dp)Arrays.fill(row,-1);
        return f(i-1,j-1,grid,dp);
    }
}