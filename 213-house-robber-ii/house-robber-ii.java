class Solution {
    private int robHouse(int[] num, int start, int end){
        int n = end-start+1;
        int[] dp = new int[n];
        dp[0] = num[start];
        dp[1] = Math.max(num[start], num[start+1]);
        for(int i=2;i<n;i++){
            dp[i]=Math.max(dp[i-1], num[i+start]+dp[i-2]);
        }
        return Arrays.stream(dp).max().getAsInt();
    }
    public int rob(int[] nums) {
        int n=nums.length;
        if (n == 0) return 0;
        if (n == 1) return nums[0];
        if (n == 2) return Math.max(nums[0], nums[1]);
        int first = robHouse(nums, 0, n-2);
        int second = robHouse(nums, 1, n-1);

        return Math.max(first, second);
    }
}