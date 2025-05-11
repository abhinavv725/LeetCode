class Solution {
    int nums;
    int[][] matrix;
    private void dfs(int r, int c, int n){
        if(n==1){
            matrix[r][c] =--nums;
            return;
        }
        n=n/2;
        dfs(r, c, n);
        dfs(r+n, c, n);
        dfs(r+n, c+n, n);
        dfs(r, c+n, n);
    }

    public int[][] specialGrid(int n) {
        int size =(int) Math.pow(2, n);
        nums = size*size;
        matrix = new int[size][size];
        dfs(0,0, size);
        return matrix;
    }
}