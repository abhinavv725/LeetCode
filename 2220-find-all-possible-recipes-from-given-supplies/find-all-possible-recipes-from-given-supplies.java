class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        List<String> ans = new ArrayList<>();
        Set<String> supply = new HashSet<>();
        for(String su: supplies){
            supply.add(su);
        }
        boolean progress=true;
        while(progress){
            progress=false;
            for(int i=0;i<recipes.length;i++){
                String r = recipes[i];
                if(ans.contains(r)) continue;
                List<String> ing = ingredients.get(i);
                boolean canMake = true;
                for(String ingre: ing){
                    if(!supply.contains(ingre)){
                        canMake=false;
                        break;
                    }
                }
                if(canMake){
                    supply.add(r);
                    ans.add(r);
                    progress=true;
                }

            }

        }
        

        return ans;
    }
}