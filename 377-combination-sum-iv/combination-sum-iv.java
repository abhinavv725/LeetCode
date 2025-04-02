class Solution {
    private int dfs(int[] nums, int target){
        if(target==0)
            return 1;
        if(target<0 )
            return 0;
        int sum=0;
        for(int j =0;j<nums.length;j++){
            sum+= dfs(nums, target-nums[j]);
        }
        return sum;
    }
    private int tab(int[] nums, int target){
        int n= nums.length;
        int[] dp = new int[target+1];
        dp[0]=1;
        for(int t= 1;t<=target;t++){
            for(int q: nums){
                if(t-q>=0)
                    dp[t] += dp[t-q]; 
            }
        }

        return dp[target];

    }
    public int combinationSum4(int[] nums, int target) {
        return tab( nums, target);
    }
}