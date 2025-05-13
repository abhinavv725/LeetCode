class Solution {
    public int countSquares(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        // dp[i][j] will store the size of the largest square ending at (i, j)
        int[][] dp = new int[n][m];
        int ans = 0;

        // Initialize the first column
        for (int i = 0; i < n; i++) {
            dp[i][0] = matrix[i][0];  // Only 1x1 squares possible in the first column
            ans += dp[i][0];          // Add to total count
        }

        // Initialize the first row
        for (int j = 0; j < m; j++) {
            dp[0][j] = matrix[0][j];  // Only 1x1 squares possible in the first row
            ans += dp[0][j];          // Add to total count
        }

        // (0,0) is counted in both row and column loops, so subtract once to fix double count
        ans -= matrix[0][0];

        // Process the rest of the matrix
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (matrix[i][j] == 1) {
                    // The size of square ending at (i,j) is determined by the min of:
                    // top, left, and top-left neighbors (extend the smallest square)
                    dp[i][j] = 1 + Math.min(
                        dp[i - 1][j], 
                        Math.min(dp[i - 1][j - 1], dp[i][j - 1])
                    );
                } else {
                    dp[i][j] = 0;  // Cannot form a square ending at (i,j)
                }
                ans += dp[i][j];  // Add count of squares ending at (i,j)
            }
        }

        return ans;  // Total count of square submatrices with all ones
    }
}
