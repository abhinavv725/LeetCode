class Solution {
    HashMap<String, Integer> map = new HashMap<>();

    private int dfs(int i, int[] nums, int target){
        if(i>=nums.length){
            return target==0 ? 1:0;
        }
        String key = i+","+target;
        if(map.containsKey(key))    return map.get(key);

        int ans=0;

        ans+=dfs(i+1, nums, target-nums[i]);
        ans+=dfs(i+1, nums, target+nums[i]);
        map.put(key, ans);
        return ans;
    }
    public int findTargetSumWays(int[] nums, int target) {
        return dfs(0, nums, target);
    }
}