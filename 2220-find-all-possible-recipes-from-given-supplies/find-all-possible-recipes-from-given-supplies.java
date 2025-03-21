class Solution {
    private boolean checkRecepie( List<String> ingredients, HashSet<String> sup){
        for(String i: ingredients){
            if(!sup.contains(i)){
                return false;
            }
        }

        return true;
    }
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        HashSet<String> sup = new HashSet<>();

        for(String s: supplies){
            sup.add(s);
        }
        List<String> ans = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<recipes.length;i++){
            q.add(i);
        }
        int lastSize=-1;
        while(sup.size()> lastSize){
            lastSize=sup.size();
            int length = q.size();
            while(length-- > 0){
                int recipeId = q.poll();
                if(checkRecepie(ingredients.get(recipeId), sup)){
                    ans.add(recipes[recipeId]);
                    sup.add(recipes[recipeId]);
                }else{
                    q.add(recipeId);
                }
            }
        }
        return ans;
    }
}