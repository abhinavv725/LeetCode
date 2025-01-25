class Solution {
    private class Node{
        int i;int j; int gold;
        Node(int i, int j, int gold){
            this.i=i;
            this.j=j;
            this.gold=gold;
        }
    }
    private boolean isValid(int i, int j, int n, int m){
        if(i>=0 && j>=0 && i<n && j<m)
            return true;
        return false;
    }
    private int solve(int i, int j, int[][] grid, int n, int m,boolean[][] visit){
        if(!isValid(i, j, n,m) || grid[i][j]==0 || visit[i][j])
            return 0;

        visit[i][j]=true;
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        int ans = 0;
        
        for(int k=0;k<4;k++){
            ans = Math.max(ans, solve(i+dx[k], j+dy[k], grid, n,m,visit));
        }
        
        
        visit[i][j]=false;;
        return ans+grid[i][j];

    }
    public int getMaximumGold(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int ans=0;
        boolean[][] visit = new boolean[n][m];
        for(int i =0;i<n;i++ ){
            for(int j=0;j<m;j++){
                if(grid[i][j]!=0){
                    int temp = solve(i, j, grid, n,m, visit);
                    ans = Math.max(ans, temp);
                }
            }
        }
        return ans;
    }
}