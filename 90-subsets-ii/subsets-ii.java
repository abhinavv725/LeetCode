class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    private void dfs(int i, List<Integer> temp, int[]nums){
        if(i==nums.length){
            ans.add(new ArrayList<>(temp));

            return;
        }
        ans.add(new ArrayList<>(temp));

        for(int j=i;j<nums.length;j++){
            if(j>i && nums[j]==nums[j-1])   continue;
            temp.add(nums[j]);
            dfs(j+1, temp, nums);
            temp.remove(temp.size()-1);
        }

    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        dfs(0,new ArrayList<>(), nums);
        

        return ans;
    }
}