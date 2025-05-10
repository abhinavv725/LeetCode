class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<int[]>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] f: flights){
            adj.get(f[0]).add(new int[] {f[1], f[2]});
        }
        int[] dis = new int[n];
        Arrays.fill(dis, Integer.MAX_VALUE);
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {0, src, k+1}); //cost, node, stops

        while(!q.isEmpty()){
            int[] curr = q.poll();
            int cost =curr[0], node = curr[1], stops = curr[2];
            if(stops>0){
                for(int[] nei: adj.get(node)){
                    int newCost = cost+nei[1];
                    if(dis[nei[0]]> newCost){
                        dis[nei[0]] = newCost;
                        q.add(new int[] {newCost, nei[0], stops-1});
                    }
                }
            }
        }
        return dis[dst] == Integer.MAX_VALUE ? -1 : dis[dst];
    }
}