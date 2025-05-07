class Solution {
    int nums;
    int[][] ans;
    private void solve(int r, int c, int size){
        if(size==1){
            ans[r][c] = --nums;
            return;

        }
        int n=size/2;
        solve(r, c, n);
        solve(r+n, c, n);
        solve(r+n, c+n, n);
        solve(r, c+n, n);
    }
    public int[][] specialGrid(int n) {
        int size = (int) Math.pow(2, n);
        ans = new int[size][size];

        nums = size*size;
        solve(0,0,size);


        return ans;
        
    }
}