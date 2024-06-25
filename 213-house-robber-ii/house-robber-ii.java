class Solution {
    
    public int helper(int[] nums){
        int n=nums.length;
        
        int[] dp= new int[n];
        
        dp[0]=nums[0];
        if(n<=1){
            return dp[0];
        }
        dp[1]=Math.max(nums[1],nums[0]);
        
        
        for(int i=2;i<n;i++){
            dp[i]=Math.max(dp[i-1],nums[i]+dp[i-2]);
        }
        return dp[n-1];
        
    }
    
    public int rob(int[] nums) {
        if(nums.length<=1){
            return nums[0];
        }
        int[] newArray1 = Arrays.copyOfRange(nums, 1, nums.length);
        int[] newArray2 = Arrays.copyOfRange(nums, 0, nums.length-1);
        return Math.max(helper(newArray1),helper(newArray2));
        
    }
}