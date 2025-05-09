class Solution {
    private boolean isValid(int i, int j, int n){
        return i>=0 && j>=0 && i<n && j<n;
    }
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid[0][0]==1)
            return -1;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0,0,1});
        int n=grid.length;
        boolean[][] vis = new boolean[n][n];
        vis[0][0]=true;
        if(grid[0][0]==0 && n==1)return 1;
        while(!q.isEmpty()){
            int size=q.size();
            while(size-- >0){
                int[] curr = q.poll();
                for(int i=-1;i<=1;i++){
                    for(int j=-1;j<=1;j++){
                        int ni = curr[0]+i;
                        int nj = curr[1]+j;
                        if(isValid(ni, nj, n) && grid[ni][nj]==0 && !vis[ni][nj]){
                            vis[ni][nj]=true;
                            q.add(new int[]{ni, nj, curr[2]+1});
                            if(ni==n-1 && nj==n-1){
                                return curr[2]+1;
                            }
                        }
                    }
                }
            }
        }
        return -1;

    }
}