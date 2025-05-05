class Solution {
    private int findlower(int[] nums, int start, int target){
        int end = nums.length;
        while(start<end){
            int mid = (start+end)/2;
            if(nums[mid]<target){
                start=mid+1;
            }else{
                end=mid;
            }   
        }
        return start;
    }
    private int findUpper(int[] nums, int start, int target){
        int end = nums.length;
        while(start<end){
            int mid = (start+end)/2;
            if(nums[mid]<=target){
                start=mid+1;
            }else{
                end=mid;
            }   
        }
        return start;
    }
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        long ans=0;

        for(int i=0;i<nums.length;i++){
            int low = findlower(nums, i+1, lower-nums[i]);
            int up = findUpper(nums, i+1, upper-nums[i]);

            ans+= (up-low);
        }




        return ans;


    }
}