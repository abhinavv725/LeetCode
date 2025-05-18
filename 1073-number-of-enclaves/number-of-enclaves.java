class Solution {
    private class Pair {
        int i; int j;
        Pair(int i, int j){
            this.i=i;
            this.j=j;
        }
    }
    private void bfs(int i, int j, int n, int m, 
                    int[][] grid, boolean[][] visit){
        
        int[] dx = {-1,0,1,0};
        int[] dy = {0,1,0,-1};
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(i,j));
        visit[i][j]=true;
        while(!q.isEmpty()){
            Pair p = q.poll();
            for(int x=0;x<4;x++){
                int nr = p.i+dx[x];
                int nc = p.j+dy[x];

                if(isValid(nr,nc, n,m) && grid[nr][nc]==1 && !visit[nr][nc]){
                    q.add(new Pair(nr,nc));
                    visit[nr][nc]=true;
                }
            }
        }
    }
    private boolean isValid(int i, int j, int n, int m){
        if(i>=0 && j>=0 && i<n && j<m)
            return true;
        return false;
    }

    public int numEnclaves(int[][] grid) {
        int n=grid.length;
        int m = grid[0].length;
        boolean[][] visit = new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if((i==0 || j==0 || i==n-1 || j==m-1) 
                && !visit[i][j] && grid[i][j]==1){
                    bfs(i,j,n,m,grid,visit);
                }
            }
        }

        int ans=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1 && !visit[i][j])
                    ans++;
            }
        }
        return ans;
    }
}