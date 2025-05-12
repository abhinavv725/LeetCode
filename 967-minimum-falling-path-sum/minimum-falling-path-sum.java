class Solution {
    private boolean isValid(int i, int j, int n){
        return i>=0 && j>=0 && i<n && j<n;
    }
    public int minFallingPathSum(int[][] matrix) {
        int n=matrix.length;
        int[][] dp = new int[n][n];
        for(int i=0;i<n;i++){
            dp[0][i] = matrix[0][i];
        }
        for(int i=1;i<n;i++){
            for(int j=0;j<n;j++){
                dp[i][j] = 100000;
                if(isValid(i-1, j-1, n)){
                    dp[i][j] =Math.min(dp[i][j], dp[i-1][j-1]);
                }
                if(isValid(i-1, j, n)){
                    dp[i][j] =Math.min(dp[i][j], dp[i-1][j]);
                }
                if(isValid(i-1, j+1, n)){
                    dp[i][j] =Math.min(dp[i][j], dp[i-1][j+1]);
                }
                dp[i][j]+=matrix[i][j];
            }
        }
        return Arrays.stream(dp[n-1]).min().getAsInt();
    }
}