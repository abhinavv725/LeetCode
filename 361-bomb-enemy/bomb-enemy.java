class Solution {
    private void fillRowColumn(int i, int j,int[][] matrix,char[][] grid){
        int n = grid.length;
        int m=grid[0].length;
        for(int row=i-1;row>=0 && grid[row][j] != 'W';row--){
            if(grid[row][j]=='0')matrix[row][j]++;
        }
        for(int row=i+1;row<n && grid[row][j] != 'W';row++){
            if(grid[row][j]=='0')matrix[row][j]++;
        }
        for(int col=j-1;col>=0 && grid[i][col] != 'W';col--){
            if(grid[i][col]=='0')matrix[i][col]++;
        }
        for(int col=j+1;col<m && grid[i][col] != 'W';col++){
            if(grid[i][col]=='0')matrix[i][col]++;
        }
    }
    public int maxKilledEnemies(char[][] grid) {
        int n = grid.length;
        int m=grid[0].length;
        int[][] matrix = new int[n][m];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='E')
                    fillRowColumn(i, j, matrix, grid);
            }
        }
        int ans=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='0')
                    ans = Math.max(ans, matrix[i][j]);
            }
        }
        return ans;

    }
}