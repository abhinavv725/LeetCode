class Pair{
    int i;
    int j;
    int step;
    Pair(int _i,int _j, int _step){
        this.i=_i;
        this.j=_j;
        this.step=_step;
    }
}


class Solution {
    
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        
        int[][] ans= new int[n][m];
        boolean[][] vis = new boolean[n][m];
        
        Queue<Pair> q = new LinkedList<>(); 
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j]==0){
                    vis[i][j]=true;
                    q.add(new Pair(i,j,0));
                }
            }
        }
        int[]drow = {-1,0,1,0};
        int []dcol = {0,1,0,-1};
        
        while(!q.isEmpty()){
            int i = q.peek().i;
            int j=q.peek().j;
            int step = q.peek().step;
            
            q.remove();
            ans[i][j]=step;
            for(int t=0;t<4;t++){
                int nrow=i+drow[t];
                int ncol=j+dcol[t];
                
                if(nrow>=0 && nrow<n && ncol>=0 && ncol< m && vis[nrow][ncol]==false){
                    vis[nrow][ncol]=true;
                    q.add(new Pair(nrow,ncol,step+1));
                }
                
            }
            
            
        }
        
        
        
        return ans;
        
    }
}