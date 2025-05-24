class Solution {
    HashSet<Integer> col = new HashSet<>();
    HashSet<Integer> posDiagonal = new HashSet<>();
    HashSet<Integer> negDiagonal = new HashSet<>();
    List<List<String>>  ans = new ArrayList<>();
    char[][] board;
    private void dfs(int r, int n){
        if(r==n){
            List<String> temp = new ArrayList<>();
            for(char[] row: board){
                temp.add(new String(row));
            }
            ans.add(temp);
            
            return;
        }else{
            for(int c=0;c<n;c++){
                int posDia = r+c;
                int negDia = r-c;
                if(col.contains(c) || posDiagonal.contains(posDia) || negDiagonal.contains(negDia))
                    continue;
                col.add(c);
                posDiagonal.add(posDia);
                negDiagonal.add(negDia);
                board[r][c] = 'Q';
                dfs(r+1, n);
                col.remove(c);
                posDiagonal.remove(posDia);
                negDiagonal.remove(negDia);
                board[r][c] = '.';

            }
        }
    }
    public List<List<String>> solveNQueens(int n) {
        board = new char[n][n];
        for(char[] row: board){
            Arrays.fill(row, '.');
        }
        dfs(0, n);
        return ans;
        
    }
}