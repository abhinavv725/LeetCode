class Solution {
    private int prims(List<List<int[]>> adj, int n){
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a,b) -> Integer.compare(a[1], b[1])
        );
        boolean[] vis = new boolean[n];

        int sum=0;
        pq.add(new int[] {0,0});
        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int node = curr[0];
            int wt =curr[1];
            if(!vis[node]){
                vis[node]=true;
                sum+=wt;

                for(int[] temp: adj.get(node)){
                    int nei = temp[0];
                    int neiWt = temp[1];
                    if(!vis[nei]){
                        pq.add(new int[] {nei, neiWt});
                    }
                }
            }
        }
        return sum;
    }
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        List<List<int[]>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int x1 = points[i][0];
                int x2 = points[j][0];
                int y1 = points[i][1];
                int y2 = points[j][1];
                int d = Math.abs(x1-x2)+Math.abs(y1-y2);

                adj.get(i).add(new int[] {j, d});
                adj.get(j).add(new int[] {i, d});
            }
        }
        return prims(adj, n);
    }
}