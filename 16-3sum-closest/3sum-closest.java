class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int diff = nums[0]+nums[1]+nums[2];
        Arrays.sort(nums);
        
        for(int i=0;i<nums.length;i++){
            if(i>0 && nums[i]==nums[i-1]){
                continue;
            }
            int j=i+1, k = nums.length-1;
            while(j<k){
                int sum = nums[i]+nums[j]+nums[k];
                if(sum==target){
                    return sum;
                }
                if(Math.abs(target-sum)<Math.abs(target-diff)){
                    diff =sum;
                }
                else if(sum<target){
                    j++;
                }else{
                    k--;
                }

            }
        }
        return diff;
    }
}