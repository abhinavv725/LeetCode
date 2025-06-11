class Solution {
    int[][] directions = {{1, 2}, {-1, 2}, {1, -2}, {-1, -2},
                            {2, 1}, {2, -1}, {-2, 1}, {-2, -1}};
    private boolean isValid(int i, int j, int n){
        return i>=0 && j>=0 && i<n && j<n;
    }
    public double knightProbability(int n, int k, int row, int column) {
        double[][][] dp = new double[k+1][n][n];
        dp[0][row][column] = 1;
        for(int a=1;a<=k;a++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    for(int[] dir: directions){
                        int nI = i+dir[0], nJ = j+dir[1];
                        if(isValid(nI, nJ, n)){
                            dp[a][i][j] += dp[a-1][nI][nJ]/8.0;
                        }
                    }
                }
            }
        }
        double ans=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                ans+=dp[k][i][j];
            }
        }
        return ans;
    }
}