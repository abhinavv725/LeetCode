class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int n=nums.length;
        Arrays.sort(nums);
        int closestSum=nums[0]+nums[1]+nums[2];
        for(int i=0;i<n-2;i++){
            int j=i+1, k=n-1;

            while(j<k){
                int currSum = nums[i]+nums[j] + nums[k];
                if(Math.abs(closestSum-target)>Math.abs(currSum-target)){
                    closestSum=currSum;
                }
                if(currSum==target)
                    return currSum;
                
                if(currSum>target){
                    k--;
                }else{
                    j++;
                }
            }
        }
        return closestSum;
    }
}