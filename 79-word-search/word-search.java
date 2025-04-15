class Solution {
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0,-1,0,1};
    private boolean isValid(int i, int j, int n, int m){
        return i>=0 && j>=0 && i<n && j<m;
    }
    private boolean dfs(int i, int j, int x,String word, char[][] board,boolean[][] vis){
        if(x==word.length()){
            return true;
        }
        vis[i][j]=true;
        boolean ans=false;

        for(int y=0;y<=3;y++){
            int ni = i+dx[y];
            int nj = j+dy[y];
            if(isValid(ni, nj, board.length, board[0].length) 
            && board[ni][nj] == word.charAt(x) && !vis[ni][nj]){
                ans |= dfs(ni, nj, x+1, word, board, vis); 
            }
        }
        vis[i][j]=false;

        return ans;
    }
    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;

        boolean[][] vis = new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                vis = new boolean[n][m];
                if((word.charAt(0) == board[i][j]) && dfs(i, j, 1, word, board, vis)){
                    return true;
                }
            }
        }
        return false;
    }
}