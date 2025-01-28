class Solution {
    private class Pair{
        int i;int j;
        Pair(int i, int j){
            this.i=i;
            this.j=j;
        }
    }
    private boolean isValid(int i,int j, int n, int m){
        return i>=0 && j>=0 && i<n && j<m;
    }
    private void fillTable(int i,int j, int n, int m, boolean[][] visit, 
                            int prev,int[][] grid){
        
        if(!isValid(i,j,n,m) || prev > grid[i][j] || visit[i][j] )
            return;
        visit[i][j]=true;
        fillTable(i+1,j,n,m,visit, grid[i][j], grid);
        fillTable(i,j+1,n,m,visit, grid[i][j], grid);
        fillTable(i-1,j,n,m,visit, grid[i][j], grid);
        fillTable(i,j-1,n,m,visit, grid[i][j], grid);
        

    }
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        int n=heights.length;
        int m=heights[0].length;

        boolean[][] atl = new boolean[n][m]; 
        boolean[][] pac = new boolean[n][m];

         // Traverse Pacific (top and left boundaries)
        for (int i = 0; i < n; i++) {
            fillTable(i, 0, n, m, pac, heights[i][0], heights); // Left boundary
        }
        for (int j = 0; j < m; j++) {
            fillTable(0, j, n, m, pac, heights[0][j], heights); // Top boundary
        }

        // Traverse Atlantic (bottom and right boundaries)
        for (int i = 0; i < n; i++) {
            fillTable(i, m - 1, n, m, atl, heights[i][m - 1], heights); // Right boundary
        }
        for (int j = 0; j < m; j++) {
            fillTable(n - 1, j, n, m, atl, heights[n - 1][j], heights); // Bottom boundary
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(atl[i][j] && pac[i][j]){
                    ans.add(Arrays.asList(i,j));
                }
            }
        }
        return ans;
    }
}