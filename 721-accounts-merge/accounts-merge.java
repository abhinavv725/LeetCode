class DSU {
    int[] parent;
    int[] rank;
    DSU(int n){
        parent = new int[n]; 
        rank = new int[n]; 
        for(int i=0;i<n;i++){
            parent[i]=i;
            rank[i]=1;
        }
    }
    public boolean union(int a, int b){
        int rootA = find(a);
        int rootB = find(b);
        if(rootA==rootB){
            return false;
        }
        else if(rootA>rootB){
            parent[rootB] = rootA;
            rank[rootA] += rank[rootB];
        }else{
            parent[rootA] = rootB;
            rank[rootB] += rank[rootA];
        }
        return true;
    }
    public int find(int a){
        if(parent[a]==a){
            return a;
        }
        return parent[a] = find(parent[a]);
    }
}
class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        DSU dsu = new DSU(n);

        HashMap<String, Integer> emailToId = new HashMap<>();
        for(int i=0;i<n;i++){
            for(int j=1;j<accounts.get(i).size();j++){
                String email = accounts.get(i).get(j);
                if(emailToId.containsKey(email)){
                    dsu.union(i, emailToId.get(email));
                }else{
                    emailToId.put(email, i);
                }
            }
        }
        HashMap<Integer, Set<String>> map = new HashMap<>();
        for(int i=0;i<n;i++){
            List<String> acc = accounts.get(i);
            int root = dsu.find(i);
            if(!map.containsKey(root)){
                map.put(root, new HashSet<>());
            }
            for(int j=1;j<acc.size();j++){
                map.get(root).add(acc.get(j));
            }
            
        }
        List<List<String>> ans = new ArrayList<>();
        for(int root: map.keySet()){
            List<String> acc = new ArrayList<>(map.get(root));
            Collections.sort(acc);
            acc.add(0, accounts.get(root).get(0));
            ans.add(acc);
        }
        return ans;
    }
}












