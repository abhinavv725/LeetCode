class Solution {
    int nums;
    private void dfs(int r, int c, int[][] ans, int size){
        if(size==1){
            ans[r][c]=--nums;
            return;
        }
        int n = size/2;
        dfs(r, c, ans, size/2);
        dfs(r+n, c, ans, size/2);

        dfs(r+n, c+n, ans, size/2);
        dfs(r, c+n, ans, size/2);

    }
    public int[][] specialGrid(int n) {
        nums =(int) Math.pow(2, 2*n);
        int size =(int) Math.pow(2, n);
        int[][] ans = new int[size][size];
        dfs(0, 0, ans, size);
        return ans;
    }
}