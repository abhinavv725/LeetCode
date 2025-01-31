class Solution {
    private boolean isValid(int i,int j){
        return i>=0 && j>=0 && i<8 && j<8;
    }
    private boolean check(int i, int j, char[][] board, int dx, int dy, char color, boolean foundOppo){
        
        if(!isValid(i, j) || board[i][j]=='.'){
            return false;
        }
        if( board[i][j]==color)
            return foundOppo;
        return check(i+dx, j+dy, board, dx, dy, color, true);
    }
    public boolean checkMove(char[][] board, int rMove, int cMove, char color) {
        if (board[rMove][cMove] != '.') return false;

        for(int i=-1;i<=1;i++){
            for(int j=-1;j<=1;j++){
                if(i==0 && j==0){
                    continue;
                }else{
                    if(check(rMove+i, cMove+j, board, i, j, color,false)==true)
                        return true;
                }
            }
        }
        return false;
        
    }
}