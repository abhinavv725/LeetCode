class Solution {
    private boolean isValid(int[][][] grid, int i, int j){
        int n=grid.length;
        int m = grid[0].length;
        return i>=0 && j>=0 && i<n && j<m;
    }
    private void bfs(int[][][] mat, int i, int j, int[][] grid){
        Queue<int[]> q = new LinkedList<>();
        int n=mat.length;
        int m = mat[0].length;
        q.add(new int[]{i,j});
        int[] dx = {-1,0,1,0};
        int[] dy = {0,1,0,-1};
        boolean[][] vis = new boolean[n][m];
        vis[i][j]=true;
        int step=0;
        while(!q.isEmpty()){
            int p=q.size();
            while(p-- >0){
                int[] curr = q.poll();
                mat[curr[0]][curr[1]][0]+= step;
                mat[curr[0]][curr[1]][1]++;
                for(int t=0;t<=3;t++){
                    int nx = curr[0]+dx[t];
                    int ny = curr[1]+dy[t];
                    if(isValid(mat, nx, ny) && !vis[nx][ny] && grid[nx][ny]>=0){
                        vis[nx][ny]=true;
                        q.add(new int[] {nx, ny});
                    }
                }

            }
            step++;

        }
 
    }
    public int shortestDistance(int[][] grid) {
        int n=grid.length;
        int m = grid[0].length;
        int houses=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    grid[i][j]=-1;
                    houses++;
                }
                if(grid[i][j]==2){
                    grid[i][j]=-2;
                }
            }
        }
        int[][][] mat = new int[n][m][2];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==-1){
                    bfs(mat, i, j, grid);
                }
            }
        }
        int ans = (int)1e9;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==0 && mat[i][j][1]==houses){
                    ans= Math.min(ans, mat[i][j][0]);
                }
            }
        }
        return ans == (int)1e9 ? -1: ans;
    }
}