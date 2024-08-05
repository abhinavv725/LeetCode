class Pair {
    int row,col,length;
    Pair(int row, int col, int length){
        this.row=row;
        this.col=col;
        this.length=length;
    }
}
class Solution {
    public int maxDistance(int[][] grid) {
        int ans=0;
        Queue<Pair> q = new LinkedList<>();
        int n= grid.length;
        int m = grid[0].length;
        int[] drow = {-1,0,1,0};
        int[] dcol={0,1,0,-1};
        boolean[][] vis= new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    q.add(new Pair(i,j,0));
                    vis[i][j]=true;
                }
            }
        }
        while(!q.isEmpty()){
            Pair p= q.poll();
            int row=p.row;
            int col=p.col;
            int length=p.length;
            ans=Math.max(ans,length);
            for(int i=0;i<4;i++){
                int nrow=row+drow[i];
                int ncol =col+dcol[i];
                if(nrow>=0 && ncol>=0 && nrow<n && ncol<m && !vis[nrow][ncol] && grid[nrow][ncol]==0){
                    q.add(new Pair(nrow,ncol,length+1));
                    vis[nrow][ncol]=true;
                }
            }
            
        }
        
        return ans == 0 ? -1 : ans;
    }
}