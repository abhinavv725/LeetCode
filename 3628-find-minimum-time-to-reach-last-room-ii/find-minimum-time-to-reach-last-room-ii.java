class Solution {
    private boolean isValid(int i, int j, int n, int m){
        return i>=0 && j>=0 && i< n && j<m;
    }
    public int minTimeToReach(int[][] moveTime) {
        int n= moveTime.length;
        int m = moveTime[0].length;
        int[][] time = new int[n][m];
        for(int []t: time){
            Arrays.fill(t, Integer.MAX_VALUE);
        }
        time[0][0]=0;
        int[][] directions = {{0,1}, {1,0}, {0,-1},{-1,0}};
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(a[2], b[2]));
        pq.add(new int[] {0,0,0, 0});
        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int currI = curr[0];
            int currJ = curr[1];
            int currT = curr[2];
            int step = curr[3];
            if(currT> time[currI][currJ])
                continue;
            for(int[] dir: directions){
                int nI = currI+dir[0];
                int nJ = currJ+dir[1];
                if(isValid(nI, nJ, n,m)){
                    int nT = 1+ Math.max(currT, moveTime[nI][nJ]);
                    if(step==1){
                        nT++;
                    }
                    if(nT<time[nI][nJ]){
                        time[nI][nJ]=nT;
                        if(step==1){
                            pq.add(new int[] {nI,nJ, nT, 2});
                        }else{
                            pq.add(new int[] {nI,nJ, nT, 1});

                        }
                    }
                }
            }
        }
        return time[n-1][m-1];
    }
}