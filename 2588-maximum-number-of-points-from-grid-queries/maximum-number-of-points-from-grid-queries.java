class Solution {
    private boolean isValid(int i, int j, int n, int m){
        return i>=0 && j>=0 && i< n && j<m;
    }
    int[] dx ={-1, 0,1,0};
    int[] dy ={0, 1,0,-1};
    private int getAns(int[][] grid, int val, boolean[][] vis, PriorityQueue<int[]> pq){
        int points=0;
        int n = grid.length, m=grid[0].length;
        while(!pq.isEmpty()){
            int[] curr = pq.peek();
            if(curr[0]>=val)
                return points;
            pq.poll();
            points++;
            for(int i=0;i<4;i++){
                int nr = curr[1]+dx[i];
                int nc = curr[2] + dy[i];
                if(isValid(nr,nc, n,m) && !vis[nr][nc]){
                    vis[nr][nc]=true;
                    pq.add(new int[] {grid[nr][nc],nr, nc});
                }
            }

        }
        return points;

    }
    public int[] maxPoints(int[][] grid, int[] queries) {
        int[][] q = new int[queries.length][2];
        int n = grid.length, m=grid[0].length;

         boolean[][] vis = new boolean[n][m];
        for(int i=0;i<queries.length;i++){
            q[i][0] = queries[i];
            q[i][1] = i;
        }
        Arrays.sort(q, (a,b)->Integer.compare(a[0], b[0]));
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a,b)-> Integer.compare(a[0], b[0])
        );
        int[] ans = new int[queries.length];
        pq.add(new int[] {grid[0][0], 0,0});
        int temp=0;
        vis[0][0]=true;
        for(int i=0;i<q.length;i++){
            temp += getAns(grid, q[i][0], vis, pq);
            ans[q[i][1]] = temp;
        }

        return ans;

    }
}