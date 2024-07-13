class Pair{
    int i,j;
    Pair(int _i,int _j){
        this.i=_i;
        this.j=_j;
    }
} 
class Solution {
    private void bfs(int i,int j,int[][] grid,boolean[][] vis){
        Queue<Pair> q = new LinkedList<>();
        int n=grid.length;
        int m=grid[0].length;
        vis[i][j]=true;
        q.add(new Pair(i,j));
        int[] drow={-1,0,1,0};
        int[] dcol = {0,1,0,-1};
        while(!q.isEmpty()){
            int row = q.peek().i;
            int col = q.peek().j;
            q.remove();
            
            for(int t=0;t<4;t++){
                int nrow=row+drow[t];
                int ncol=col+dcol[t];
                if(nrow>=0 && nrow<=n-1 && ncol>=0 && ncol<=m-1 && vis[nrow][ncol]==false && grid[nrow][ncol]==1){
                    vis[nrow][ncol]=true;
                    q.add(new Pair(nrow,ncol));
                }
            }
        }
    
    }
    public int numEnclaves(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        
        boolean[][] vis = new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i==0 || i==n-1 || j==0 || j==m-1){
                    if(grid[i][j]==1)
                        bfs(i,j,grid,vis);
                }
            }
        }
        
        int ans=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1 && vis[i][j]==false){
                    ans++;
                }
            }
        }
        return ans;
        
    }
}