class Solution {
    int[] parent;
    int[] rank;
    private int find(int x){
        if(parent[x]==-1)   return x;
        return parent[x]=find(parent[x]);
    }
    private boolean union(int a, int b){
        int rootA = find(a);
        int rootB = find(b);
        if(rootA==rootB)    return false;
        else if(rootA>rootB){
            parent[rootB] = rootA;
            rank[rootA]+=rank[rootB];
        }else{
            parent[rootA] = rootB;
            rank[rootB]+=rank[rootA];

        }
        return true;
    }

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n=accounts.size();
        parent=new int[n];
        rank=new int[n];
        Arrays.fill(parent, -1);
        Arrays.fill(rank, 1);
        HashMap<String, Integer> emailToId = new HashMap<>();
        for(int i=0;i<n;i++){
            List<String> emails = accounts.get(i);
            for(int j=1;j<emails.size();j++){
                String e = emails.get(j);
                if(emailToId.containsKey(e)){
                    union(i, emailToId.get(e));
                }else{
                    emailToId.put(e, i);
                }
            }
        }
        HashMap<Integer, List<String>> idToEmail = new HashMap<>();
        for(String email:emailToId.keySet() ){
            int rootId = find(emailToId.get(email));
            idToEmail.computeIfAbsent(rootId, k-> new ArrayList<>()).add(email);
        }
        List<List<String>> ans = new ArrayList<>();
        for(int id: idToEmail.keySet()){
            List<String> emails = idToEmail.get(id);
            Collections.sort(emails);
            emails.add(0, accounts.get(id).get(0));
            ans.add(emails);
        }
        return ans;

    }
}