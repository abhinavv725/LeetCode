class Solution {
    
    private void dfs(int i,int j,char[][] board,boolean[][] vis){
        
        vis[i][j]=true;
        int n=board.length;
        int m=board[0].length;
        int[] drow = {-1,0,1,0};
        int[] dcol = {0,1,0,-1};
        for(int t=0;t<4;t++){
            int nrow=i+drow[t];
            int ncol=j+dcol[t];
            
            if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && vis[nrow][ncol]==false && board[nrow][ncol]=='O'){
                dfs(nrow,ncol,board,vis);
            }
        }
    }
    
    
    public void solve(char[][] board) {
        int n=board.length;
        int m=board[0].length;
        
        boolean[][] vis = new boolean[n][m];
        
        //traverse the first and last row
        for(int i=0;i<m;i++){
            if(board[0][i]=='O' && vis[0][i]==false){
                dfs(0,i,board,vis);
            }
            if(board[n-1][i]=='O' && vis[n-1][i]==false){
                dfs(n-1,i,board,vis);
            }
            
        }
        //traverse the first and last col
        for(int i=0;i<n;i++){
            if(board[i][0]=='O'&& vis[i][0]==false){
                dfs(i,0,board,vis);
            }
            if(board[i][m-1]=='O' && vis[i][m-1]==false){
                dfs(i,m-1,board,vis);
            }
        }
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]=='O' && vis[i][j]==false){
                    board[i][j]='X';
                }
            }
        }
    }
}