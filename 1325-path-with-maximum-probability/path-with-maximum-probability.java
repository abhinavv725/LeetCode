class Solution {
    private class Pair {
        int dest;
        double prob;
        Pair(int dest, double prob){
            this.dest=dest; this.prob=prob;
        }
    }
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            adj.get(edges[i][0]).add(new Pair(edges[i][1], succProb[i]));
            adj.get(edges[i][1]).add(new Pair(edges[i][0], succProb[i]));
        }
        double[] ans= new double[n];
        Arrays.fill(ans, 0.0);
        ans[start_node] = 1;
        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingDouble((Pair p) -> -p.prob));
        pq.add(new Pair(start_node, 1.0));

        while(!pq.isEmpty()){
            Pair curr = pq.poll();
            int node = curr.dest;
            double prob = curr.prob;
            if(node==end_node)
                return prob;

            for(Pair nei: adj.get(node)){
                int nNode = nei.dest;
                double probNew = nei.prob *prob;
                if(ans[nNode]<probNew){
                    ans[nNode] = probNew;
                    pq.add(new Pair( nNode, probNew));
                }
            }

        }
        return 0.0;
    }
}