class Solution {
    private boolean isValid(int[] nums, int p, int threshold){
        int i=0, c=0;
        while(i<nums.length-1){
            if(nums[i+1]-nums[i]<=threshold){
                c++;i+=2;
            }else{
                i++;
            }
        }
        return c>=p;
    }
    public int minimizeMax(int[] nums, int p) {
        Arrays.sort(nums);
        int n = nums.length, ans=0;
        int l=0, r = nums[n-1];
        while(l<=r){
            int mid = l+(r-l)/2;
            if(isValid(nums, p, mid)){
                ans = mid;
                r=mid-1;
            }else{
                l=mid+1;
            }
        }
        return ans;
    }
}