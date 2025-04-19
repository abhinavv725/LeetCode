class Solution {
    private int lower_bound(int[] nums, int start, int target){
        int low = start, high = nums.length;
        while(low<high){
            int mid = (low+high)/2;
            if(nums[mid]<target)
                low = mid+1;
            else
                high = mid;
        }
        return low;
    }
    private int upper_bound(int[] nums, int start, int target){
        int low = start, high = nums.length;
        while(low<high){
            int mid = (low+high)/2;
            if(nums[mid]<=target)
                low = mid+1;
            else
                high = mid;
        }
        return low;
    }
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        long ans=0;

        for(int i=0;i<nums.length;i++){
            int left = lower_bound(nums, i+1, lower-nums[i]);

            int right = upper_bound(nums, i+1, upper-nums[i]);

            ans += (right-left);
        }
        return ans;
    }
}