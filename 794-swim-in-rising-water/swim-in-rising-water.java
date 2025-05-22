class Solution {
    private boolean isValid(int i, int j, int[][] grid){
        int n=grid.length;
        return i>=0 && j>=0 && i< n && j<n;
    }
    int[][] directions = {{-1, 0}, {0,-1}, {1,0}, {0,1}};
    private boolean canSwim(int i, int j, int max, int[][] grid, boolean[][] vis){
        if(i==grid.length-1 && j==grid.length-1){
            return true;
        }
        vis[i][j]=true;
        for(int[] dir: directions){
            int newI = i+dir[0];
            int newJ = j+dir[1];
            if(isValid(newI, newJ, grid) && grid[newI][newJ]<=max && !vis[newI][newJ]){
                if(canSwim(newI, newJ, max, grid, vis)){
                    return true;
                }
            }
        }
        return false;

    }
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int start=Math.max(grid[0][0], grid[n-1][n-1]), end = n*n, ans=0;
        while(start<=end){
            int mid = (start+end)/2;
            if(canSwim(0,0, mid, grid, new boolean[n][n])){
                ans = mid;
                end = mid-1; 
            }else{
                start=mid+1;
            }
        }

        return ans;

    }
}