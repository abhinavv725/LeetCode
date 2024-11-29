class Solution {
    
    public int solve(int[] nums, int ind, int target, int curr){
        if(ind<0 && target==curr)return 1;
        if(ind<0 )return 0;
        
        return solve(nums, ind-1, target, curr+nums[ind]) + 
            solve(nums, ind-1, target, curr-nums[ind]);
    }
    public int findTargetSumWays(int[] nums, int target) {
        return solve(nums, nums.length-1, target, 0);
        
    }
}