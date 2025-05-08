class Solution {
    public int[] searchRange(int[] nums, int target) {
        int first=-1, second=-1;
        int l=0, r= nums.length-1;

        while(l<=r){
            int mid = (l+r)/2;
            if(nums[mid]==target){
                first = mid;
                r=mid-1;
            }else if(nums[mid]>target){
                r=mid-1;
            }else {
                l=mid+1;
            }
        }
        l=0; r= nums.length-1;
        while(l<=r){
            int mid = (l+r)/2;
            if(nums[mid]==target){ 
                second = mid;
                l=mid+1;
            }else if(nums[mid]>target){
                r=mid-1;
            }else {
                l=mid+1;
            }
        }

        return new int[] {first, second};
    }
}