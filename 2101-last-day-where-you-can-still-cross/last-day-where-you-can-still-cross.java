class Solution {
    private boolean isValid(int i, int j, int n, int m){
        return i>=0 && j>=0 && i<n && j<m;
    }
    private boolean canCross(int n, int m, int[][] mat){
        Queue<int[]> q = new LinkedList<>();
        boolean[][] vis = new boolean[n][m];

        for(int i=0;i<m;i++){
            if(mat[0][i]==0){
                q.add(new int[] {0, i});
                vis[0][i]=true;
            }
        }
        int[][] directions = {{1, 0}, {0,1}, {-1, 0}, {0,-1}};
        while(!q.isEmpty()){
            int[] curr = q.poll();
            int i = curr[0], j=curr[1];
            if(i==n-1)  return true;

            for(int[] dir: directions){
                int nx = i+dir[0], ny = j+dir[1];
                if(isValid(nx, ny, n, m) && !vis[nx][ny] && mat[nx][ny]==0){
                    vis[nx][ny]=true;
                    q.add(new int[] {nx, ny});
                }
            }


        }
        return false;
    }





    private boolean check(int r, int c, int[][] cells, int m){
        int[][] mat = new int[r][c];
        for(int i=0;i<m;i++){
            int[] cell = cells[i];
            mat[cell[0]-1][cell[1]-1]=1;
        }
        
        return canCross(r, c, mat);

    }
    public int latestDayToCross(int row, int col, int[][] cells) {
        int l=0, h = cells.length;
        int ans=0;
        while(l<=h){
            int m = (l+h)/2;
            if(check(row, col, cells, m)){
                ans= m;
                l=m+1;
            }else{
                h=m-1;
            }
        }
        return ans;
    }
}