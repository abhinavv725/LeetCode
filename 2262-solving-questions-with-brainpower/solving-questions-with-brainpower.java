class Solution {
    // Recursive function to calculate the maximum points starting from index i
    private long getPoints(int i, int[][] questions, long[] dp) {
        // Base case: if index is beyond the array, return 0
        if (i >= questions.length)
            return 0;

        // If we've already computed the result for this index, return it
        if (dp[i] != -1)
            return dp[i];

        // Option 1: Solve the current question
        // Add the points for this question and recurse on the next allowed index (i + brainpower + 1)
        long choose = questions[i][0] + getPoints(i + questions[i][1] + 1, questions, dp);

        // Option 2: Skip the current question and move to the next
        long notChoose = getPoints(i + 1, questions, dp);

        // Store the best of the two choices in the DP array and return it
        return dp[i] = Math.max(choose, notChoose);
    }

    // Main function
    public long mostPoints(int[][] questions) {
        // Initialize a memoization array to store results for each index
        long[] dp = new long[questions.length];
        Arrays.fill(dp, -1); // Fill with -1 to indicate uncomputed states

        // Start recursion from index 0
        return getPoints(0, questions, dp);
    }
}
