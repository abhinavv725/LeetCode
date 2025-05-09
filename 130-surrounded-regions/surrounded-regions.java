class Solution {
    int[][] directions = {{0,1}, {1,0}, {0,-1},{-1,0}};
    private boolean isValid(int i, int j, int n, int m){
        return i>=0 && j>=0 && i<n && j<m;

    }
    private void dfs(int i, int j, char[][] board, boolean[][] vis){
        vis[i][j]=true;
        for(int[] dir: directions){
            int ni = dir[0]+i;
            int nj = dir[1]+j;
            if(isValid(ni, nj, board.length, board[0].length) && !vis[ni][nj] && board[ni][nj]=='O'){
                dfs(ni, nj, board, vis);
            }
        }
    }
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        boolean[][] vis =new boolean[n][m];
        for(int i=0;i<n;i++){
            if(board[i][0] == 'O'){
                dfs(i, 0, board, vis);
            }
            if(board[i][m-1]=='O'){
                dfs(i, m-1, board, vis);
            }
        }
        for(int j=0;j<m;j++){
            if(board[0][j] == 'O'){
                dfs(0, j, board, vis);
                
            }
            if(board[n-1][j]=='O'){
                dfs(n-1, j, board, vis);
                
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]=='O' && !vis[i][j]){
                    board[i][j]='X';
                }
            }
        }
    }
}