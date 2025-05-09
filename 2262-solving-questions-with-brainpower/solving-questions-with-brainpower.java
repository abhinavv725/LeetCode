class Solution {
    private long getPoints(int i, int[][] questions, long[] dp){
        if(i>=questions.length)
            return 0;
        if(dp[i]!=-1)
            return dp[i];
        
        long choose = questions[i][0] + getPoints(i+questions[i][1]+1, questions,dp);
        long notChoose = getPoints(i+1, questions, dp);
        return dp[i]=Math.max(choose,notChoose );
    }
    public long mostPoints(int[][] questions) {
        long[] dp = new long[questions.length];
        Arrays.fill(dp, -1);
        return getPoints(0, questions, dp);
    }
}