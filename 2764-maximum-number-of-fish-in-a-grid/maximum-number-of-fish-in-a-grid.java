class Solution {
    private class Pair {
        int i;int j;
        Pair(int i, int j){
            this.i=i;
            this.j=j;
        }
    }
    private boolean isValid(int i, int j, int n, int m){
        return i>=0 && j>=0 && i<n && j<m; 
    }
    private int solve(int i, int j, int n, int m, int[][] grid,boolean[][] visit){
        int[] dx = {-1,0,1,0};
        int[] dy = {0,-1, 0,1};
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(i,j));
        visit[i][j]=true;
        int ans=grid[i][j];
        while(!q.isEmpty()){
            Pair p = q.poll();
            for(int x=0;x<=3;x++){
                int nr = p.i+dx[x];
                int nc = p.j+dy[x];

                if(isValid(nr,nc, n,m) && !visit[nr][nc] && grid[nr][nc]!=0){
                    ans+=grid[nr][nc];
                    q.add(new Pair(nr,nc));
                    visit[nr][nc]=true;
                }
            }
        }
        return ans;
    }
    public int findMaxFish(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        boolean[][] visit = new boolean[n][m];
        int ans=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]!=0 && !visit[i][j]){
                    ans=Math.max(ans, solve(i,j,n,m,grid,visit));
                }
            }
        }
        return ans;
    }
}