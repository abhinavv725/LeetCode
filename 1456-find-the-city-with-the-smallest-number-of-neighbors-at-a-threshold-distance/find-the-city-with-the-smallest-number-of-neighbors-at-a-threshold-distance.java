class Solution {
    private int dfs(int curr, List<List<int[]>> adj, int n, int distanceThreshold){
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(a[1], b[1]));
        pq.add(new int[] {curr, 0});
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[curr]=0;
        int count=0;
        while(!pq.isEmpty()){
            int[] node = pq.poll();
            int currNode = node[0];
            int currWeight = node[1];
            if(currWeight>dist[currNode])
                continue;
            for(int[] nei: adj.get(currNode)){
                int newNode = nei[0];
                int newWeight = currWeight+nei[1];
                if(newWeight<dist[newNode]){
                    pq.add(new int[] {newNode, newWeight});
                    dist[newNode] = newWeight;
                    
                }
            } 
        }
        for(int i=0;i<n;i++){
            if(i!=curr && dist[i]<=distanceThreshold)
                count++;
        }
        return count;

    }
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        List<List<int[]>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] e: edges){
            adj.get(e[0]).add(new int[]{e[1], e[2]});
            adj.get(e[1]).add(new int[]{e[0], e[2]});
        }

        int[] arr = new int[n];
        int ans=0;
        int shortestCount=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            int temp =dfs(i, adj, n, distanceThreshold);
            if(shortestCount>=temp){
                shortestCount=temp;
                ans=i;
            }
            
        }
        return ans;
        
    }
}