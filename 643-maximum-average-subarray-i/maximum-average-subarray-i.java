class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double ans=0,temp=0;
        for(int i=0;i<k;i++){
            temp+=(double)nums[i]/k;
        }
         ans=temp;
        for(int i=k;i<nums.length;i++){
            temp+=(double)nums[i]/k;
            temp-=(double)nums[i-k]/k;
            
            ans=Math.max(ans,temp);
            
        }
        return ans;
        
    }
}