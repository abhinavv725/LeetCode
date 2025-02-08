class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        int[] ans = new int[n];
        List<List<Integer>> red = new ArrayList<>();
        List<List<Integer>> blue = new ArrayList<>();
        
        for(int i=0;i<n;i++){
            red.add(new ArrayList<>());
            blue.add(new ArrayList<>());
        }
        for(int i=0;i<redEdges.length;i++){
            red.get(redEdges[i][0]).add(redEdges[i][1]);
        }
        for(int i=0;i<blueEdges.length;i++){
            blue.get(blueEdges[i][0]).add(blueEdges[i][1]);
        }
        Arrays.fill(ans,-1);
        Queue<int[]> q =new LinkedList<>();
        q.add(new int[] {0,0,-1}); //node, length, color
        Set<String> visit = new HashSet<>();
        visit.add(0+" "+-1);
        while(!q.isEmpty()){
            int[] c = q.poll();
            int node = c[0], length=c[1], color=c[2];

            if(ans[node]==-1)
                ans[node] = length;
            if(color!=1){ //expolre red
                for(int nei : red.get(node)){
                    String state=nei +" "+ 1;
                    if(!visit.contains(state)){
                        visit.add(state);
                        q.add(new int[]{nei, length+1, 1});
                    }
                }
            }
            if(color!=0){ //expolre blue
                for(int nei : blue.get(node)){
                    String state=nei +" "+ 0;
                    if(!visit.contains(state)){
                        visit.add(state);
                        q.add(new int[]{nei, length+1, 0});
                    }
                }
            }
        }


        return ans;
    }
}