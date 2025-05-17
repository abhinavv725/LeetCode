class Solution {
    List<List<Integer>> ans;
    private void dfs(int[] nums, List<Integer> temp,boolean[] used ){
        if(temp.size()==nums.length){
            ans.add(new ArrayList<>(temp));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(used[i]) continue;
            used[i]=true;
            temp.add(nums[i]);
            dfs(nums, temp, used);
            temp.remove(temp.size()-1);
            used[i]=false;
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        ans = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        dfs(nums, new ArrayList<>(), used);

        return ans;
        
    }
}