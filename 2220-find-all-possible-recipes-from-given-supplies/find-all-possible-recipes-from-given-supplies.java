class Solution {
    private boolean dfs(String recipe, Map<String, List<String>> graph ,
            Set<String> supplySet ,Map<String, Boolean> canMake, Set<String> vis){
            if(supplySet.contains(recipe))  return true;
            if(canMake.containsKey(recipe)) return canMake.get(recipe);
            if(!graph.containsKey(recipe))  return false;
            if(vis.contains(recipe))        return false;
            vis.add(recipe);
            for(String ing: graph.get(recipe)){
                if(!dfs(ing, graph, supplySet, canMake, vis)){
                    vis.remove(recipe);
                    canMake.put(recipe, false);
                    return false;
                }
            }
            vis.remove(recipe);
            canMake.put(recipe, true);
            return true;

    }

    
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        List<String> ans = new ArrayList<>();
        Set<String> supplySet = new HashSet<>();
        Map<String, Boolean> canMake = new HashMap<>();
        for(String s: supplies){
            supplySet.add(s);
        }
        Map<String, List<String>> graph = new HashMap<>();
        for(int i=0;i<recipes.length;i++){
            graph.put(recipes[i], ingredients.get(i));
        }
        for(String recipe: recipes){
            if(dfs(recipe, graph, supplySet, canMake, new HashSet<>())){
                ans.add(recipe);
            }
        }

        return ans;
    }
}