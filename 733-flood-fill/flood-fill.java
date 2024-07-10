class Solution {
    
    private void dfs(int[][] image,int[][] mat , int r, int c, 
                     int newColor,int oldColor,
                     int[] delRow,int[] delCol){
        
        int n=image.length, m=image[0].length;
        mat[r][c]=newColor;
        
        for(int i=0;i<4;i++){
            int nrow=r+delRow[i];
            int ncol=c+delCol[i];
        
            if(nrow>=0 && nrow<n && ncol>=0 && 
               ncol<m && mat[nrow][ncol]!=newColor 
               && image[nrow][ncol]==oldColor){

                dfs(image,mat,nrow,ncol,newColor,oldColor,delRow,delCol);
            }
        }
    }
    
    
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int[][] mat = image;
        int oldColor= mat[sr][sc];
        int[] delRow={-1,0,+1,0};
        int[] delCol={0,+1,0,-1};
        dfs(image, mat, sr,sc,newColor,oldColor,delRow,delCol);
        return mat;
    }
}