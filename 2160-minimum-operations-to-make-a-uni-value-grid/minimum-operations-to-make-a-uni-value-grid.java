class Solution {
    private boolean checkPossible(int[][] grid, int x, int t){
        int n=grid.length;
        int m=grid[0].length;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]%x!=t)
                    return false;
            }
        }
        return true;
    }
    public int minOperations(int[][] grid, int x) {
        if(checkPossible(grid, x, grid[0][0]%x)==false)
            return -1;
        int n=grid.length;
        int m=grid[0].length;
        int[] arr = new int[n*m];
        int index=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                arr[index++] = grid[i][j];
            }
        }
        int res=0;
        Arrays.sort(arr);
        int median = arr[arr.length/2];
        for(int i=0;i<arr.length;i++){
            res+= (Math.abs(median-arr[i]))/x;
        }
        return res;

    }
}