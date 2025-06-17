class Solution {
    int[][] direction = {{0,1}, {1,0}, {0,-1}, {-1, 0}};

    private boolean isValid(int i, int j, int n){
        return i>=0 && j>=0 && i<n && j<n; 
    }
    private boolean check(int m, int[][] grid, int n){
        if (grid[0][0] < m) return false;
        Queue<int[]> q = new LinkedList<>();
        boolean[][] vis = new boolean[n][n];
        q.add(new int[] {0,0});
        vis[0][0] =true;
        while(!q.isEmpty()){
            int[] curr = q.poll();
            int i=curr[0], j=curr[1];
            if(i==n-1 && j==n-1){
                return true;
            }
            for(int[] dir: direction){
                int ni=i+dir[0], nj=j+dir[1];
                if(isValid(ni, nj, n) && !vis[ni][nj] && grid[ni][nj]>=m){
                    
                    q.add(new int[] {ni, nj});
                    vis[ni][nj]=true;
                }
            }
        }
        return false;
    }
    public int maximumSafenessFactor(List<List<Integer>> grid) {
        int n = grid.size();
        int[][] g = new int[n][n];
        boolean[][] vis = new boolean[n][n];

        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            List<Integer> row = grid.get(i);
            Arrays.fill(g[i], Integer.MAX_VALUE);
            for (int j = 0; j < n; j++){
                if(grid.get(i).get(j)==1){
                    q.add(new int[] {i, j});
                    vis[i][j]=true;
                    g[i][j]=0;
                }
            }
        }
        // if(g[0][0]==1 || g[n-1][n-1]==1)    
        //     return 0;
        int l=0, h = n*2;
        while(!q.isEmpty()){
            int[] curr =  q.poll();
            int i= curr[0], j=curr[1];
            for(int[] dir: direction){
                int ni = i+dir[0], nj = j+dir[1];
                if(isValid(ni, nj, n) &&!vis[ni][nj]){

                    g[ni][nj] =1+g[i][j];
                    
                    q.add(new int[] {ni, nj});
                    vis[ni][nj]=true;
                }
            }

        }
        int ans=0;
        while(l<=h){
            int m = (l+h)/2;
            if(check(m, g, n)){
                ans = m;      // store best so far
        l = m + 1;
            }else{
                h=m-1;
            }
        }
        return ans;



    }
}