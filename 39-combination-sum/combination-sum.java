class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    private void dfs(int i, List<Integer> temp, int[] candidates, int target){
        if(target==0){
            ans.add(new ArrayList<>(temp));
            return ;
        }
        if(target<0){
            return;
        }
        // temp.add(candidates[i]);
        for(int j=i;j<candidates.length;j++){
            temp.add(candidates[j]);
            dfs(j, temp, candidates, target-candidates[j]);
            temp.remove(temp.size()-1);
            
        }
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        dfs(0, new ArrayList<>(), candidates, target);
        return ans;
    }
}