class Solution {
    private boolean isValid(int i, int j, int n, int m){
        return i>=0 && j>=0 && i<n && j<m;
    }
    int[][] directions = {{-1, 0},{0,-1},{1,0},{0,1}};
    private void dfs(int i, int j,int[][] heights, boolean[][] vis){
        int n = heights.length;
        int m = heights[0].length;
        vis[i][j]=true;
        for(int[] dir: directions){
            int ni = i+dir[0];
            int nj = j+dir[1];
            if(isValid(ni, nj, n,m) && !vis[ni][nj] && heights[ni][nj]>=heights[i][j]){
                dfs(ni, nj, heights, vis);
            }
        }
    }
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;

        boolean[][] pac = new boolean[n][m];
        boolean[][] atl = new boolean[n][m];

        for(int i=0;i<n;i++){
            if(!pac[i][0]) dfs(i, 0, heights, pac);
            if(!atl[i][m-1]) dfs(i, m-1, heights, atl);
        }
        for(int j=0;j<m;j++){
            if(!pac[0][j]) dfs(0, j, heights, pac);
            if(!atl[n-1][j]) dfs(n-1, j, heights, atl);
        }


        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(pac[i][j] && atl[i][j]){
                    ans.add(Arrays.asList(i, j));
                }
            }
        }
        return ans;

    }
}