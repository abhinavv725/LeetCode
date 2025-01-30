class Solution {
    private boolean isBipartite(int i,HashMap<Integer, ArrayList<Integer>> adj,
                                    int n,int[] color){
        Queue<Integer> q = new LinkedList<>();
        q.add(i);
        color[i]=0;
        while(!q.isEmpty()){
            int ele = q.poll();
            for(int nei: adj.getOrDefault(ele, new ArrayList<>())){
                if(color[nei]==-1){
                    color[nei]=1-color[ele];
                    q.add(nei);
                }else if(color[nei]==color[ele]){
                    return false;
                }
            }
        }
        return true;
        
    }
    private int getDist(int i,int n,HashMap<Integer, ArrayList<Integer>> adj){
        Queue<Integer> q = new LinkedList<>();
        q.add(i);
        boolean[] visit= new boolean[n+1];
        int level=0;
        visit[i]=true;
        while(!q.isEmpty()){
            int nt = q.size();
            for(int x=0;x< nt;x++){
                int ele = q.poll();
                for(int nei: adj.getOrDefault(ele, new ArrayList<>())){
                    if(visit[nei]==false){
                        q.add(nei);
                        visit[nei]=true;
                    }
                    
                }
            }
            level++;
        }
        return level;
    }
    private int getMaxComp(int i,int[] maxdist, HashMap<Integer, 
                            ArrayList<Integer>> adj, boolean[] visit ){
        
        Queue<Integer> q = new LinkedList<>();
        q.add(i);
        visit[i]=true;
        int maxi=maxdist[i];
        while(!q.isEmpty()){
            int ele = q.poll();
            
            for(int nei: adj.getOrDefault(ele, new ArrayList<>())){
                maxi=Math.max(maxi, maxdist[nei]);
                if(visit[nei]==false){
                    q.add(nei);
                    visit[nei]=true;
                    
                }
            }
        }
        return maxi;

    }
    public int magnificentSets(int n, int[][] edges) {
        HashMap<Integer, ArrayList<Integer>> adj = new HashMap<>();
        
        for(int[] edge:edges){
            adj.putIfAbsent(edge[0], new ArrayList<>());
            adj.putIfAbsent(edge[1], new ArrayList<>());
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        int[] color = new int[n+1];
        Arrays.fill(color,-1);
        for(int i=1;i<=n;i++){
            if(color[i]!=-1)
                continue;
            if(!isBipartite(i, adj, n,color)){
                return -1;
            }
        }
        int[] maxdist = new int[n+1];
        for(int i=1;i<=n;i++){
            maxdist[i] = getDist(i,n, adj);
        }
        int ans=0;
        boolean[] visit = new boolean[n+1];
        for(int i=1;i<=n;i++){
            if(visit[i]==false){
                ans+=getMaxComp(i,maxdist,adj, visit);
            }
        }
        return ans;
    }
}