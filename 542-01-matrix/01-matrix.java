class Solution {
    int[][] directions = {{0,1}, {1,0},{0,-1},{-1,0}};
    private boolean isValid(int i, int j, int n, int m){
        return i>=0 && j>=0 && i<n && j<m;
    }
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m=mat[0].length;
        int[][] ans = new int[n][m];
        for(int[] a: ans){
            Arrays.fill(a, (int)1e9);
        }
        boolean[][] vis = new boolean[n][m];
        Queue<int[]> q = new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j]==0){
                    q.add(new int[] {i, j, 0});
                    vis[i][j]=true;
                    
                }
            }
        }
        while(!q.isEmpty()){
            int size = q.size();
            while(size-- >0){
                int[] curr = q.poll();
                int i = curr[0], j=curr[1], dist = curr[2];
                ans[i][j] = dist;
                for(int[] dir: directions){
                    int ni = i+dir[0], nj = j+dir[1];
                    if(isValid(ni, nj, n,m) && mat[ni][nj] ==1 && !vis[ni][nj]){
                        q.add(new int[] {ni, nj, dist+1});
                        vis[ni][nj]=true;
                    }
                }
            }
        }
        return ans;
        
    }
}