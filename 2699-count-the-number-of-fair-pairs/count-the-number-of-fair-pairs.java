class Solution {
    private int findLower(int start, int target, int[] nums){
        int end = nums.length-1;
        while(start<=end){
            int mid = (start+end)/2;
            
            if(nums[mid]>=target){
                end=mid-1;
            }else{
                start=mid+1;
            }
        }
        return end;

    }
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        long ans=0;
        for(int i=0;i<nums.length;i++){
            int up = findLower(i+1, upper-nums[i]+1, nums);
            int down = findLower(i+1, lower-nums[i], nums);
            ans+= (up-down);
        }
        return ans;
    }
}