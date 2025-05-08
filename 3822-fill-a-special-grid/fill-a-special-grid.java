class Solution {
    int[][] ans;
    int nums;
    private void fillGrid(int r, int c, int size){
        if(size==1){
            ans[r][c] = --nums;
            return;
        }
        int n = size/2;
        fillGrid(r, c, n);
        fillGrid(r+n, c, n);
        fillGrid(r+n, c+n, n);
        fillGrid(r, c+n, n);

    }
    public int[][] specialGrid(int n) {
        int size = (int) Math.pow(2, n) ;
        ans = new int[size][size];
        nums=size*size;

        fillGrid(0,0,size);
        return ans;

        
    }
}