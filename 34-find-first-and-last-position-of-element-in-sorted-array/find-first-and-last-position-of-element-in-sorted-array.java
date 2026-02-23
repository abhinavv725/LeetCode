class Solution {
    private int lowerBound(int[] nums, int target){  
        int l=0, r=nums.length;
        while(l<r){
            int m = l+(r-l)/2;
            if(nums[m]>=target){
                r=m;
            }else{
                l=m+1;
            }
        }
        return l;
    }
    public int[] searchRange(int[] nums, int target) {
        int first = lowerBound(nums, target);
        if(first==nums.length || nums[first]!=target){
            return new int[] {-1, -1};
        }
        int second = lowerBound(nums, target+1)-1;
        return new int[] {first, second};

    }
}