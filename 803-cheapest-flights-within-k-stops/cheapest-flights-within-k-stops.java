class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<int[]>> adj = new ArrayList<>();
	
            for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        for(int[] flight: flights){
            adj.get(flight[0]).add(new int[] {flight[1], flight[2]});
        }

        int[] destination = new int[n];
        Arrays.fill(destination, Integer.MAX_VALUE);
        Queue<int[]> q = new LinkedList<>(); 
        q.add(new int[] {src, 0, k+1});
        while(!q.isEmpty()){
            
            int[] curr = q.poll();
            int start = curr[0], amount = curr[1], stop=curr[2];
            if(stop<=0) 
                continue;
            for(int[] nei: adj.get(start)){
                int newCost = amount+nei[1];
                if(destination[nei[0]]> newCost){
            
                    destination[nei[0]]= newCost;
                    q.add(new int[] {nei[0], newCost, stop-1});
                }
                
            }
        }

        return destination[dst] == Integer.MAX_VALUE ? -1: destination[dst];

    }
}