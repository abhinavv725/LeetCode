class Solution {
    private boolean isValid(int i, int j, int n, int m){
        return i>=0 && j>=0 && i<n && j<m;
    }
    int[][] directions = {{-1, 0}, {1, 0}, {0,1},{0,-1}};
    private boolean dfs(int i, int j, int k, String word,char[][] board, boolean[][] vis){
        if(k==word.length())
            return true;
        vis[i][j]=true;
        for(int[] dir: directions){
            int ni = i+dir[0];
            int nj =j+dir[1];
            if(isValid(ni, nj, board.length, board[0].length) 
            && word.charAt(k) == board[ni][nj] 
            && !vis[ni][nj]){
                if(dfs(ni, nj, k+1, word, board, vis))
                    return true;
            }

        }
        vis[i][j]=false;
        return false;

    }
    public boolean exist(char[][] board, String word) {
        char[] arr = word.toCharArray();
        int n=board.length,m= board[0].length;
        boolean[][] vis = new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j] == word.charAt(0)){
                    if(dfs(i, j, 1, word, board, vis)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}