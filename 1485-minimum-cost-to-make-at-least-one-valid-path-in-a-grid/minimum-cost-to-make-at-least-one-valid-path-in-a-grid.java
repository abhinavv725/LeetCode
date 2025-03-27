class Solution {
    int[] dx = {0,0,1,-1};
    int[] dy = {1,-1,0,0}; 
    private boolean isValid(int i,int j,int n,int m){
        return i>=0 && j>=0 && i<n && j<m;
    }
    private void dfs(int i, int j, int[][] grid, int[][] arr){
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> Integer.compare(a[0], b[0]));

        pq.add(new int[] {0, i,j});
        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int currWeight = curr[0];
            int currI = curr[1];
            int currJ = curr[2];
            if(currWeight> arr[currI][currJ])
                continue;
           
            for(int t=0;t<4;t++){
                int nI = currI+dx[t], nJ =currJ+dy[t];
                int weight = (t+1==grid[currI][currJ] ? 0:1) + currWeight;
                if(isValid(nI, nJ, grid.length, grid[0].length) ){
                    if(weight < arr[nI][nJ]){
                        pq.add(new int[] {weight, nI, nJ});
                        arr[nI][nJ] = weight;
                    }
                
                }
            }
        }
    }

    public int minCost(int[][] grid) {
        int n = grid.length;
        int m=grid[0].length;
        int[][] arr = new int[n][m];
        for(int[] r: arr){
            Arrays.fill(r, Integer.MAX_VALUE);
        }
        arr[0][0]=0;
        dfs(0,0, grid, arr);
        return arr[n-1][m-1];
    }
}