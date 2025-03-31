class Solution {
    private boolean isValid(int i, int j, int n , int m){
        return i>=0 && j>=0 && i<n && j<m;
    }
    public int[][] highestPeak(int[][] isWater) {
        int n=isWater.length;
        int maxi = Integer.MAX_VALUE;
        int m = isWater[0].length;
        int[][] height = new int[n][m];
        Queue<int[]> q = new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                height[i][j]=-1;
                if(isWater[i][j]==1){
                    height[i][j]=0;
                    q.add(new int[] {i,j});
                }
            }
        }
        int[] dx = {-1, 0,1,0};
        int[] dy = {0, 1,0,-1};
        while(!q.isEmpty()){
            int size = q.size();
            while(size-- >0 ){
                int[] curr = q.poll();
                int i =curr[0], j=curr[1];
                for(int t=0;t<=3;t++){
                    int nr = i+dx[t];
                    int nc = j+dy[t];
                    if(isValid(nr, nc, n,m) && height[nr][nc]==-1){
                        height[nr][nc] = height[i][j]+1;
                        q.add(new int[] {nr, nc});
                    }
                }
            }
        }
        return height;
    }
}