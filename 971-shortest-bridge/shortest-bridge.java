class Solution {
    private void dfs(int i, int j, int n, int[][] grid, boolean[][] visit,Queue<int[]> q ){
        if(i<0 || j<0 || i==n || j==n || grid[i][j]==0 || visit[i][j])
            return ;
        visit[i][j]=true;
        q.add(new int[] {i,j});
        dfs(i+1,j,n, grid, visit,q);
        dfs(i-1,j,n, grid, visit,q);
        dfs(i,j+1,n, grid, visit,q);
        dfs(i,j-1,n, grid, visit,q);

    }
    private boolean isValid(int i, int j, int n){
        return i>=0 && j>=0 && i<n && j<n;
    }
    public int shortestBridge(int[][] grid) {
        int n = grid.length;
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visit = new boolean[n][n];
        int i=0, j=0;
        for(i=0;i<n;i++){
            boolean found=false;
            for(j=0;j<n;j++){
                if(grid[i][j]==1 && !visit[i][j]){
                    dfs(i, j,n, grid, visit,q);
                    found=true;
                    break;
                }
            }
            if(found)
                break;
        }
        int steps=0;
        int[][] directions = {{-1,0}, {1,0}, {0,1},{0,-1}}; 
        while(!q.isEmpty()){
            int t = q.size();
            while(t--!=0){
                int[] cell = q.poll();
                int x = cell[0], y = cell[1];
                for(int[] dir: directions){
                    int nr = x+dir[0], nc = y+dir[1];
                    if(isValid(nr,nc, n) && !visit[nr][nc]){
                        if(grid[nr][nc]==1)
                            return steps;
                        q.add(new int[] {nr,nc});
                        visit[nr][nc]=true;
                    }
                }
            
            }
            steps++;
        }
        return -1;


    }
}