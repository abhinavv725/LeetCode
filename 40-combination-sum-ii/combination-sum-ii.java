class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    private void findCombination(int i, int target, List<Integer>temp,  int[] candidates){
        if(target==0){
            ans.add(new ArrayList<>(temp));
            return;
        }
        if(target<0)    return ;
        for(int j=i;j<candidates.length; j++){
            if(j>i && candidates[j]==candidates[j-1]) continue;
            temp.add(candidates[j]);
            findCombination(j+1, target-candidates[j], temp, candidates);
            temp.remove(temp.size()-1);
        }

    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        findCombination(0, target, new ArrayList<>(), candidates);
        return ans;
    }
}