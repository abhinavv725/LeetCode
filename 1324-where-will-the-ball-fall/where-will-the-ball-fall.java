class Solution {
    
    private int solve(int i, int j, int n, int m, int[][] grid){
        if(i==n)
            return j;
        if(grid[i][j]==1){
            if(j+1>=m || grid[i][j+1]==-1){
                return -1;
            }
            return solve(i+1, j+1, n,m,grid);
        }else{
            if(j-1<0 || grid[i][j-1]==1){
                return -1;
            }
            return solve(i+1, j-1, n,m, grid);
        }

    }
    public int[] findBall(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[] ans = new int[m];
        for(int j=0;j<m;j++){
            ans[j] = solve(0, j, n, m, grid);
        }
        return ans;
    }
}