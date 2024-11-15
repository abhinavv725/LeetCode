class Solution {
    
    public int solve(int n,List<List<Integer>> triangle, int currRow, int currI,int[][] dp){
        if(dp[currRow][currI]!=-1)return dp[currRow][currI];
        
        if(currRow==n-1)return triangle.get(currRow).get(currI);
        
        if(currI>triangle.get(currRow).size())return 0;
        
        return dp[currRow][currI]=triangle.get(currRow).get(currI)+
            Math.min(solve(n,triangle, currRow+1, currI,dp), 
                     solve(n,triangle, currRow+1, currI+1,dp));
    }
    
    public int minimumTotal(List<List<Integer>> triangle) {
        int[][] dp =new int[triangle.size()][triangle.size()];
        for(int[] row: dp)
            Arrays.fill(row, -1);
        return solve(triangle.size(), triangle, 0,0,dp);
    }
}