class Solution {
    int ans=0;
    private boolean isValid(int i, int j, int[][]matrix){
        int n= matrix.length;
        int m=matrix[0].length;
        return i>=0 && j>=0 && i<n && j<m;

    }
    private int dfs(int i, int j, int[][] matrix, int[][] dp){
        if(!isValid(i, j, matrix))
            return 0;
        if(dp[i][j]!=0) 
            return dp[i][j];
        int[][] dir= {{-1,0}, {1, 0}, {0, -1}, {0, 1}};
        int maxLen=0;
        for(int[] d: dir){
            int nx = i+d[0];
            int ny = j+d[1];
            if(isValid(nx, ny, matrix) && matrix[i][j]<matrix[nx][ny]){
                maxLen = Math.max(maxLen, 1+ dfs(nx, ny, matrix, dp));
            }
        }
        return dp[i][j]=maxLen;

    }
    public int longestIncreasingPath(int[][] matrix) {
        int n= matrix.length;
        int m=matrix[0].length;
        int ans=0;
        int[][] dp = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                ans = Math.max(ans, dfs(i, j, matrix, dp));
                
            }
        }
        return ans+1;
    }
}