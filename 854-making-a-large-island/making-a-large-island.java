class Solution {
    private boolean isValid(int i, int j, int n){
        return i>=0 && j>=0 && i<n && j<n;
    }
    private int dfsSum(int i, int j, int label, int n, int[][] grid){
        if(!isValid(i, j, n) || grid[i][j]!=1){
            return 0;
        }
        grid[i][j]=label;
        int size=1;
        size+= dfsSum(i+1,j,label, n,grid);
        size+= dfsSum(i-1,j,label, n,grid);
        size+= dfsSum(i,j+1,label, n,grid);
        size+= dfsSum(i,j-1,label, n,grid);
        return size;
    }
    private int count(int i, int j, int n, int[][] grid, 
                        HashMap<Integer, Integer> map){
        
        int res=1;
        HashMap<Integer, Boolean> visit = new HashMap<>();
        int[] dx = {-1,0,1,0};
        int[] dy = {0,-1,0,1};
        for(int x=0;x<=3;x++){
            int nr = i+dx[x];
            int nc = j+dy[x];
            if(isValid(nr,nc, n) && grid[nr][nc]>1 && !visit.containsKey(grid[nr][nc])){
                res+=map.get(grid[nr][nc]);
                visit.put(grid[nr][nc], true);
            }
        }
        return res;

    }
    public int largestIsland(int[][] grid) {
        int n=grid.length;
        int label=2;
        HashMap<Integer, Integer> map = new HashMap<>();
        int max1=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    int islandSum = dfsSum(i, j, label, n, grid);
                    max1=Math.max(max1,islandSum );
                    map.put(label, islandSum);
                    label++;
                }
            }
        }
        if (max1 == n * n) return max1;
        int ans =max1;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==0){
                   ans=Math.max(ans, count(i,j,n,grid,map)); 
                }
            }
        }
        return ans;
        
    }
}