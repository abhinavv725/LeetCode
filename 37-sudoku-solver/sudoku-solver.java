class Solution {
    HashSet<String> row = new HashSet<>();
    HashSet<String> col = new HashSet<>();
    HashSet<String> box = new HashSet<>();
    private boolean dfs(int i, int j, char[][] board){
        if(i==board.length)
            return true;
        if(j==board.length)
            return dfs(i+1, 0 , board);
        int n = board.length;
        if(board[i][j]!='.')   
            return dfs(i, j+1, board);
        
        for(char c = '1';c<='9';c++){

            String ro = c+"-row-"+i;
            String co = c+"-col-"+j;
            String bo = c+"-box-"+i/3+"_"+j/3;
            if(row.contains(ro) || col.contains(co) || box.contains(bo)){
                continue;
            }
            row.add(ro);
            col.add(co);
            box.add(bo);
            board[i][j] = c;

            if(dfs(i, j+1, board))
                return true;
            board[i][j] = '.';

            row.remove(ro);
            col.remove(co);
            box.remove(bo);

            
        }
        return false;

    }
    public void solveSudoku(char[][] board) {
        int n = board.length;

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]!='.'){
                    char c = board[i][j];
                    String ro = c+"-row-"+i;
                    String co = c+"-col-"+j;
                    String bo = c+"-box-"+i/3+"_"+j/3;

                    row.add(ro);
                    col.add(co);
                    box.add(bo);

                }
            }
        }
        dfs(0, 0, board);
    }
}