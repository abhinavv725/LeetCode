class Solution {
    private double dfs(HashMap<String ,HashMap<String, Double>> adj, String a, String b, double product,Set<String> visited ){

        if(a.equals(b)){
            return product;
        }
        visited.add(a);
        for(Map.Entry<String, Double> nei: adj.get(a).entrySet()){
            if(visited.contains(nei.getKey())==false){
                double result = dfs(adj, nei.getKey(), b, product*nei.getValue(), visited);
                if(result!=-1.0)
                    return result;
            }
        }
        return -1;

    }
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        HashMap<String, HashMap<String, Double>> map = new HashMap<>();
        for(int i=0;i<equations.size();i++){
            double value = values[i];
            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);

            map.putIfAbsent(a,new HashMap<>());
            map.putIfAbsent(b,new HashMap<>());
            map.get(a).put(b, value);
            map.get(b).put(a, 1.0/value);
        }
        int n = queries.size();
        double[] ans = new double[n];

        for(int i=0;i<n;i++){
            String a = queries.get(i).get(0);
            String b = queries.get(i).get(1);

            if(!map.containsKey(a) || !map.containsKey(b)){
                ans[i]=-1.0;
            }else{
                Set<String> visited = new HashSet<>();
                ans[i] = dfs(map, a,b, 1.0, visited);
            }
        }

        return ans;
     }
}