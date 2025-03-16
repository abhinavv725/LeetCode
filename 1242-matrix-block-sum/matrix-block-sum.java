class Solution {
    private boolean isValid(int i, int j, int m, int n){
        return i>=0 && j>=0 && i<m && j<n;
    }
    private int solve(int i, int j, int[][]mat, int k, int m, int n){
        int sum=0;

        for(int a = i-k;a<=i+k;a++){
            for(int b = j-k;b<=j+k;b++){
                if(isValid(a,b,m,n)){
                    sum+=mat[a][b];
                }
            }
        }
        return sum;

    }
    public int[][] matrixBlockSum(int[][] mat, int k) {
        int m=mat.length;
        int n=mat[0].length;
        int[][] ans = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                ans[i][j]=solve(i,j,mat, k, m,n);
            }
        }
        return ans;
    }
}