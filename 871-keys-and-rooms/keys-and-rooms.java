class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n= rooms.size();
        boolean[] visit = new boolean[n];

        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        visit[0]=true;
        while(!q.isEmpty()){
            int node = q.poll();
            for(int nei: rooms.get(node)){
                if(!visit[nei]){
                    q.add(nei);
                    visit[nei] = true;
                }
            }
        }
        for(int i=0;i<n;i++){
            if(visit[i]==false)
                return false;
        }
        return true;
    }
}