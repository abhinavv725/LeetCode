class Graph {
    List<List<int[]>> adj;
    int n;
    public Graph(int n, int[][] edges) {
        adj = new ArrayList<>();
        this.n = n;
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge: edges){
            adj.get(edge[0]).add(new int[] {edge[1], edge[2]});
        }

    }
    
    public void addEdge(int[] edge) {
        adj.get(edge[0]).add(new int[] {edge[1], edge[2]});
        
    }
    
    public int shortestPath(int node1, int node2) {
        if(node1==node2)
            return 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(a[1], b[1]));
        pq.add(new int[] {node1, 0});
        int[] cost = new int[n];
        Arrays.fill(cost, Integer.MAX_VALUE);
        cost[node1]=0;
        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int node = curr[0], weight = curr[1];
            for(int[] nei: adj.get(node)){
                if(cost[nei[0]]>weight+nei[1]){
                    cost[nei[0]] = weight+nei[1];
                    pq.add(new int[] {nei[0], weight+nei[1]});
                    // if(nei[0]==node2)
                    //     return weight+nei[1];
                }
            }
        }
        return cost[node2] == Integer.MAX_VALUE ? -1: cost[node2];
    }
}

/**
 * Your Graph object will be instantiated and called as such:
 * Graph obj = new Graph(n, edges);
 * obj.addEdge(edge);
 * int param_2 = obj.shortestPath(node1,node2);
 */