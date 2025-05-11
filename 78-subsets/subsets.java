class Solution {
    List<List<Integer>> ans;
    private void dfs(int i, int[] nums, List<Integer> temp){
        if(i==nums.length){
            ans.add(new ArrayList<>(temp));
            return;
        }
        temp.add(nums[i]);
        dfs(i+1, nums, temp);
        temp.remove(temp.size()-1);
        dfs(i+1, nums, temp);

    }
    public List<List<Integer>> subsets(int[] nums) {
        ans = new ArrayList<>();
        dfs(0, nums, new ArrayList<>());
        return ans;
    }
}