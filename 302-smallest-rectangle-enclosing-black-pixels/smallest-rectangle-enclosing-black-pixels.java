class Solution {
    int maxX, maxY;
    int minX, minY ;
    private void check(int[][] mat, int x, int y, int n, int m, boolean[][] vis){
        if(x<0 || y<0 || x== n || y==m || mat[x][y]==0 || vis[x][y])
            return;
        
        vis[x][y] = true;
        maxX = Math.max(maxX, x);
        minX = Math.min(minX, x);
        maxY = Math.max(maxY, y);
        minY = Math.min(minY, y);
        check(mat, x+1, y, n, m, vis);
        check(mat, x, y+1, n, m, vis);
        check(mat, x-1, y, n, m, vis);
        check(mat, x, y-1, n, m, vis);
            

    }
    public int minArea(char[][] image, int x, int y) {
        int n = image.length;
        int m = image[0].length;
        int[][] mat = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                mat[i][j] = image[i][j] == '1' ? 1 : 0;
            }
        }
        maxX = x; minX=x; minY=y; maxY=y;
        boolean[][] vis = new boolean[n][m];
        check(mat, x, y,n,m, vis);
        
        return (maxX-minX+1) * (maxY-minY+1);

    }
}