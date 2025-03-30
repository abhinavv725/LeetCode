class Solution {
    private void dfs(int i, int j, char[][] board,boolean[][] vis ){
        
        vis[i][j]=true;
        if(i+1<board.length && board[i+1][j]=='X' && !vis[i+1][j]){
            dfs(i+1, j, board, vis);
        }
        if(j+1<board[0].length && board[i][j+1]=='X' && !vis[i][j+1]){
            dfs(i, j+1, board, vis);

        }
    }
    public int countBattleships(char[][] board) {
        int n = board.length;
        int m=board[0].length;
        boolean[][] vis = new boolean[n][m];
        int count=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]=='X' && !vis[i][j]){
                    dfs(i, j, board, vis);
                    count++;
                }
            }
        }
        return count;
    }
}