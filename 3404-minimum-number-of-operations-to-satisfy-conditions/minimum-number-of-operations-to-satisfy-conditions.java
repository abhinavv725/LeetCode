class Solution {
    private int solve(int j, int keep, int[][] dp, int[][] grid){
        int n=grid.length, m=grid[0].length;
        if(j>=m)
            return 0;
        
        if(dp[j][keep]!=-1)
            return dp[j][keep];
        
        int minAns = Integer.MAX_VALUE, cost=0;
        for(int i=0;i<n;i++){
            if(grid[i][j]!=keep)
                cost++;
        }
        for(int option=0;option<=9;option++){
            if(option==keep)
                continue;
            minAns=Math.min(minAns, cost+solve(j+1, option, dp, grid));
        }
        return dp[j][keep]=minAns;

    }
    public int minimumOperations(int[][] grid) {
        int ans = Integer.MAX_VALUE;
        int n=grid.length, m=grid[0].length;
        int[][] dp = new int[m][10];
        for(int[] r: dp)
            Arrays.fill(r,-1);
        for(int keep=0;keep<=9;keep++){
            ans = Math.min(ans, solve(0, keep, dp,grid));
        }
        return ans;
    }
}