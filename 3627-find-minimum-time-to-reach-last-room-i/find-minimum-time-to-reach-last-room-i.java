class Solution {
    private boolean isValid(int i, int j, int n, int m){
        return i>=0 && j>=0 && i<n && j<m;
    }
    public int minTimeToReach(int[][] moveTime) {
        int n=moveTime.length;
        int m=moveTime[0].length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(a[2], b[2]));
        boolean[][] vis = new boolean[n][m];
        int[][] time = new int[n][m];
        for(int[] t: time){
            Arrays.fill(t, Integer.MAX_VALUE);
        }
        time[0][0]=0;
        int[][] dir = {{0,1}, {0,-1}, {1,0}, {-1,0}};
        vis[0][0]=true;

        pq.add(new int[] {0,0,time[0][0]});
        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int currI = curr[0];
            int currJ = curr[1];
            int currT = curr[2];
            
            for(int[] d: dir){
                int nI = currI+d[0];
                int nJ = currJ+d[1];
                if(isValid(nI, nJ, n,m) && !vis[nI][nJ]){
                    int nT = 1+Math.max(currT, moveTime[nI][nJ]);
                    vis[nI][nJ]=true;
                    if(time[nI][nJ]>nT){
                        time[nI][nJ] = nT;
                        pq.add(new int[]{nI, nJ, nT});
                    }
                }
            }
        }
        return time[n-1][m-1];

    }
}