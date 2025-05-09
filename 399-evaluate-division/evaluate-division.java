class Solution {
    
    private double dfs(HashMap<String, HashMap<String, Double>> adj, String a , String b, double product, Set<String> visited){
        if(a.equals(b))
            return product;
        visited.add(a);
        HashMap<String, Double> cities = adj.get(a);
        for(String key: cities.keySet()){
            if(!visited.contains(key)){
                double temp = dfs(adj, key, b, product * cities.get(key), visited);
                if(temp!=-1.0)
                    return temp;
            }

        }
        return -1.0;
    }


    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        HashMap<String, HashMap<String, Double>> adj = new HashMap<>();
        for(int i=0;i<values.length;i++){
            double val = values[i];
            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);
            if(!adj.containsKey(a)){
                adj.put(a, new HashMap<>());
            }
            if(!adj.containsKey(b)){
                adj.put(b, new HashMap<>());
            }
            adj.get(a).put(b, val);
            adj.get(b).put(a, 1.0/val);
        }

        int n = queries.size();
        double[] ans = new double[n];
        for(int i=0;i<n;i++){
            String a = queries.get(i).get(0);
            String b = queries.get(i).get(1);
            if(!adj.containsKey(a) || !adj.containsKey(b)){
                ans[i]=-1.0;
            }else{
                Set<String> visit = new HashSet<>();
                ans[i]=dfs(adj, a, b, 1.0, visit);
            }
        }

        return ans;
        
        
    }
}