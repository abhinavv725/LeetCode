class Solution {
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, -1, 0, 1};
    int MOD = (int) Math.pow(10, 9)+7;
    private int dfs(int i, int j, int m, int n, int maxMove){
        if((i==m || j==n || i<0 || j<0) && maxMove >=0)
            return 1;
        if(maxMove<0)
            return 0;
        int ans=0;
        for(int t=0;t<4;t++){
            ans= (ans + dfs(i+dx[t], j+dy[t], m,n, maxMove-1))%MOD;
        }
        return ans%MOD;
        
    }
    private boolean isOut(int i, int j, int m, int n){
        if(i==m || j==n || i<0 || j<0)
            return true;
        return false;
    }
    private int tab(int m, int n, int maxMove, int startRow, int startColumn){
        int[][] grid = new int[m][n];

        for(int i=1;i<=maxMove;i++){
            int[][] temp = new int[m][n];
            for(int r=0;r<m;r++){
                for(int c=0;c<n;c++){
                    for(int t=0;t<4;t++){
                        int nr = r+dx[t];
                        int nc = c+ dy[t];
                        if(isOut(nr,nc, m,n)){
                            temp[r][c] = (temp[r][c]+1)%MOD;
                        }else{
                            temp[r][c] = (temp[r][c]+grid[nr][nc])%MOD;
                        }
                    }
                }
            }
            grid=temp;
        }
        return grid[startRow][startColumn];
    }
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        return tab(m,n,maxMove, startRow, startColumn);
    }
}