class Solution {
    public int[][] generateMatrix(int n) {
        int left=0, right = n-1, top=0, bottom=n-1;
        int start=1;
        int[][] matrix = new int[n][n];
        while(left<=right && top<=bottom){
            for(int i=left;i<=right;i++){
            matrix[top][i] = start++;
        }
        top++;
        for(int i=top;i<=bottom;i++){
            matrix[i][right] = start++;

        }
        right--;
        if(top<=bottom){
            for(int i=right;i>=left;i--){
                matrix[bottom][i] = start++;
            }
            bottom--;
        }
        if(left<=right){
            for(int i=bottom;i>=top;i--){
                matrix[i][left] = start++;

            }
            left++;

        }

        }
        
        
        return matrix;
    }
}