class Solution {
    public int snakesAndLadders(int[][] board) {
        int n=board.length;
        Set<Integer> visit = new HashSet<>();
        Queue<int[]> q = new LinkedList<>();

        q.add(new int[] {1,0});
        visit.add(1);
        while(!q.isEmpty()){
            int[] curr = q.poll();
            int pos = curr[0];
            int move = curr[1];

            for(int i=1;i<=6;i++){
                int newPos = pos+i;
                if(newPos>n*n)
                    break;
                int[] coord = getPost(newPos, n);
                int r = coord[0];
                int c = coord[1];

                if(board[r][c]!=-1)
                    newPos = board[r][c];
                if(newPos == n*n)
                    return move+1;
                
                if(!visit.contains(newPos)){
                    q.add(new int[] {newPos, move+1});
                    visit.add(newPos);
                }
            }
        }
        return -1;
    }
    private int[] getPost(int pos, int n){
        int row = (pos-1)/n;
        int col = (pos-1)%n;
        if(row%2!=0){
            col = n-1-col;
        }
        row = n-1-row;
        return new int[] {row, col};
    }
}