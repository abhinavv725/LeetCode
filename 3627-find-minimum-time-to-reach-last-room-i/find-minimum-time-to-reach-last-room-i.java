class Solution {
    private boolean isValid(int i, int j, int n, int m){
        return i>=0 && j>=0 && i<n && j<m;
    }
    public int minTimeToReach(int[][] moveTime) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                                (a,b) -> Integer.compare(a[2], b[2]));
        int n=moveTime.length;
        int m=moveTime[0].length;
        pq.add(new int[] {0,0,0}); //row, col, time
        int[][] directions = {{1,0}, {0,1}, {-1,0}, {0,-1}};
        int[][] time = new int[n][m];
        for(int[] t: time){
            Arrays.fill(t, Integer.MAX_VALUE);
        }
        time[0][0]=0;
        while(!pq.isEmpty()){
            int[] curr= pq.poll();
            int i=curr[0], j=curr[1], currTime=curr[2];
            if(i==n-1 && j==m-1){
                return currTime;
            }
            for(int[]dir: directions){
                int nI = i+dir[0];
                int nJ = j+dir[1];
                if(isValid(nI, nJ, n,m) ){
                    int nT = 1+Math.max(currTime, moveTime[nI][nJ]);
                    if(time[nI][nJ]>nT){
                       time[nI][nJ]=nT;
                       pq.add(new int[] {nI, nJ, nT}); 
                    }
                }
            }

        }
        return time[n-1][m-1];
    }
}