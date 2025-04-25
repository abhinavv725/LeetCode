class Solution {
    public int[][] rangeAddQueries(int n, int[][] queries) {
        int[][] pre = new int[n][n];
        int[][] a = new int[n][n];

        for(int[] q: queries){
            int r1 = q[0], r2=q[2], c1=q[1], c2=q[3];
            for(int i=r1;i<=r2;i++){
                pre[i][c1]++;
                if(c2+1<n)
                    pre[i][c2+1]--;
            }
        }
        for(int i=0;i<n;i++){
            int sum=0;
            for(int j=0;j<n;j++){
                sum+=pre[i][j];
                a[i][j] += sum;
            }
        }
        return a;
    }
}