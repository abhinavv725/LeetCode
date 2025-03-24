class Solution {
    private boolean jump(int i, int[] nums){
        if(i==nums.length)
            return false;
        if(i==nums.length-1)
            return true;
        
        for(int j=1;j<=nums[i];j++){
            if(jump(i+j, nums)){
                return true;
            }
        }
        return false;
    }
    private boolean jumpTab(int[] nums){
        int n= nums.length;
        boolean[] dp = new boolean[n];
        dp[0]=true;
        for(int i=0;i<n;i++){
            for(int j=1;j<=nums[i];j++){
                if(i+j==n)
                    break;
                dp[i+j]=dp[i];
            }
        }

        return dp[n-1];
    }
    public boolean canJump(int[] nums) {
        return jumpTab(nums);
    }
}