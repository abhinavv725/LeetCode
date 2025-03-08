class Solution {
    int res=0;
    private void dfs(int[] nums, int temp,int target){
        if(temp>target){
            return;
        }
        if(temp==target){
            res++;
            return;
        }
        for(int n: nums){
            dfs(nums, temp+n, target);
        }

    }
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target+1];
        dp[0]=1;
        for(int i=1;i<=target;i++){
            for(int n: nums){
                if(n<=i){
                    dp[i]+=dp[i-n];
                }
            }
        }
        return dp[target];
    }
}