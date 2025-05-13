class Solution {
    private int maximumSum(int[] nums){
        int n=nums.length;
        int ans=Integer.MIN_VALUE;
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=nums[i];
            ans=Math.max(ans, sum);
            sum=Math.max(sum, 0);
        }
        return ans;

    }
    private int minimumSum(int[] nums){
        int n=nums.length;
        int ans=Integer.MAX_VALUE;
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=nums[i];
            ans=Math.min(ans, sum);
            sum=Math.min(sum, 0);
        }
        return Math.abs(ans);

    }
    public int maxAbsoluteSum(int[] nums) {
        int max = maximumSum(nums);
        int min = minimumSum(nums);
        return Math.max(max, min);
    }
}