class Solution {
    private boolean isValid(int i, int j, int n, int m){
        return i>=0 && j>=0 && i<n && j<m;
    }
    int[][] directions ={{0,1},{1,0},{-1,0},{0,-1}};
    public int minimumEffortPath(int[][] heights) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                                    (a,b)-> Integer.compare(a[2],b[2])
                                );
        int n=heights.length;
        int m = heights[0].length;
        int[][] time = new int[n][m];
        for(int[] t: time){
            Arrays.fill(t, Integer.MAX_VALUE);
        }
        time[0][0]=0;
        int ans=0;
        pq.add(new int[]{0,0,0});
        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int i=curr[0], j=curr[1], effort = curr[2];
            if(curr[0]==n-1 && curr[1]==m-1){
                return curr[2];
            }

            for(int[] dir: directions){
                int nI =dir[0]+ curr[0];
                int nJ =dir[1]+ curr[1];
                if(isValid(nI, nJ, n, m)){
                    int heightDiff = Math.abs(heights[i][j] - heights[nI][nJ]);
                    int maxEffort = Math.max(effort, heightDiff);
                    if(time[nI][nJ]>maxEffort){
                        time[nI][nJ]=maxEffort;
                        pq.add(new int[] {nI, nJ, maxEffort});
                    }

                }
            }
        }
        return ans;

    }
}