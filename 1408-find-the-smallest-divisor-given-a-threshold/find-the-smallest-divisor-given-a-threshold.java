class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int l= 1, r =Arrays.stream(nums).max().getAsInt();
        int ans=0;
        while(l<=r){
            int mid = (l+r)/2;
            if(checkIfLessThanThreshold(mid, nums, threshold)){
                ans = mid;
                r=mid-1;

            }else{
                l=mid+1;
            }
        }
        return ans;
    }
    private boolean checkIfLessThanThreshold(int mid, int[] nums, int threshold){
        int sum=0;
        for(int n: nums){
            sum+= (n+mid-1)/mid;
        }
        return sum<=threshold;
    }
}