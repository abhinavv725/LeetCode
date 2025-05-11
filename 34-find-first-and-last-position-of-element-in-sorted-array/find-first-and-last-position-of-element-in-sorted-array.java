class Solution {
    public int[] searchRange(int[] nums, int target) {
        int first=-1, second=-1;
        int start=0, end =nums.length-1;
        while(start<=end){
            int mid = (start+end)/2;
            if(nums[mid]>=target){
                first=mid;
                end=mid-1;
            }else{
                start=mid+1;
            }
        }
        if(first==-1 || nums[first]!=target)
            return new int[] {-1, -1};
        start=0; end =nums.length-1;
        while(start<=end){
            int mid = (start+end)/2;
            if(nums[mid]<=target){
                second=mid;
                start=mid+1;
            }else{
                end=mid-1;
            }
        }

        return new int[] {first, second};
    }
}