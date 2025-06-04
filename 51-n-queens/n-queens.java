class Solution {
    List<List<String>> ans = new ArrayList<>();
    char[][] board;
    HashSet<Integer> col = new HashSet<>();
    HashSet<Integer> posDiagonal = new HashSet<>();
    HashSet<Integer> negDiagonal = new HashSet<>();
    private void dfs(int r, int n){
        if(r==n){
            List<String> temp = new ArrayList<>();
            for(char[] row: board){
                temp.add(new String(row));
            }
            ans.add(temp);
            
        }
        for(int c=0;c<n;c++){
            int pos =r+c;
            int neg = r-c;
            if(col.contains(c) || posDiagonal.contains(pos) || negDiagonal.contains(neg)){
                continue;
            }
            col.add(c); posDiagonal.add(pos); negDiagonal.add(neg);
            board[r][c] = 'Q';
            dfs(r+1, n);
            board[r][c]='.';
            col.remove(c); posDiagonal.remove(pos); negDiagonal.remove(neg);

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