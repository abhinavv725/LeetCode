class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<String> set = new HashSet<>();
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                char curr = board[i][j];
                if(board[i][j]=='.')
                    continue;
                
                String row = curr + "-row-" + i;
                String col = curr + "-col-" + j;
                String box = curr + "-box-" + i/3+'_'+j/3;
                if(set.contains(row) || set.contains(col) || set.contains(box))
                    return false;
                set.add(row);
                set.add(col);
                set.add(box);
            }
        }
        return true;
    }
}