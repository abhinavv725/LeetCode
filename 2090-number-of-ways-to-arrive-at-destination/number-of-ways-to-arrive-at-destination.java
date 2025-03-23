class Solution {
    int MOD = (int) Math.pow(10,9)+7;
    private class Node {
        int dest; long time;
        Node(int dest, long time){
            this.dest=dest;this.time=time;
        }
    }
    public int countPaths(int n, int[][] roads) {
        List<List<Node>> adj = new ArrayList<>();

        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] road: roads){
            adj.get(road[0]).add(new Node(road[1], road[2]));
            adj.get(road[1]).add(new Node(road[0], road[2]));
        }
        PriorityQueue<Node> pq = new PriorityQueue<>(
            (a,b) -> Long.compare(a.time, b.time)
        );
        pq.add(new Node(0,0));
        long[] shortestTime = new long[n];
        Arrays.fill(shortestTime, Long.MAX_VALUE);
        long[] pathCount = new long[n];
        shortestTime[0]=0;
        pathCount[0]=1;
        while(!pq.isEmpty()){
            Node curr = pq.poll();
            int nei = curr.dest;
            long time = curr.time;

            for(Node vec: adj.get(nei)){
                if(time+vec.time < shortestTime[vec.dest]){
                    shortestTime[vec.dest] = time+vec.time;
                    pathCount[vec.dest] = pathCount[nei];
                    pq.add(new Node(vec.dest, shortestTime[vec.dest]));

                }else if(time+vec.time == shortestTime[vec.dest]){
                    pathCount[vec.dest] = (pathCount[nei] + pathCount[vec.dest])%MOD;

                }
            }
        }
        return (int) pathCount[n-1];

    }
}