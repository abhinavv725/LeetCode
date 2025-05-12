class Solution {
    private int dfs(int i, int j, String word1, String word2,int[][] dp){
        if(i==word1.length() && j==word2.length())
            return 0;
        if(i==word1.length() || j==word2.length()){
            return Math.max(word1.length()-i, word2.length()-j);
        }
        if(dp[i][j]!=-1)    return dp[i][j];
        if(word1.charAt(i)==word2.charAt(j)){
            return dp[i][j]=dfs(i+1, j+1, word1, word2,dp); // do nothing
        }else{
            return dp[i][j]=1+ Math.min(
                dfs(i, j+1, word1, word2, dp), // Insert
                Math.min(
                    dfs(i+1, j, word1, word2, dp), //Delete
                    dfs(i+1, j+1, word1, word2, dp) //replace
                )
            );
        }
    }
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length()][word2.length()];
        for(int[] d1: dp){
            Arrays.fill(d1, -1);
        }
        return dfs(0,0,word1, word2, dp);
    }
}