class Solution {
    private boolean isvalid(int i, int j, int n, int m){
        return i>=0 && j>=0 && i<n && j<m;
    }
    int[][] direction = {{0,1}, {1,0}, {0,-1}, {-1,0}};


    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int n=grid.length;
        int m=grid[0].length;
        int freshFruits = 0;
        boolean[][] vis = new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2){
                    q.add(new int[]{i,j,0});
                    vis[i][j] =true;
                }
                if(grid[i][j]==1){
                    freshFruits++;
                }
            }
        }
        int time=0;

        while(!q.isEmpty()){
            int size=q.size();
            while(size-- >0){
                int[] curr =q.poll();
                time = Math.max(time, curr[2]);
                for(int[] dir: direction){
                    int nI = curr[0]+dir[0];
                    int nJ = curr[1]+dir[1];
                    if(isvalid(nI, nJ, n,m) && !vis[nI][nJ]){
                        if(grid[nI][nJ]==1){
                            q.add(new int[]{nI,nJ, curr[2]+1});
                            freshFruits--;
                            grid[nI][nJ]=2;
                            vis[nI][nJ]=true;
                        }

                    }
                }
            }
        }
        return (freshFruits == 0)? time:-1;
    }
}