class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        Arrays.sort(nums);
        int ans=0;
        int i=0, n=nums.length;
        while(i<nums.length){
            int j=i+1, k=n-1;
            while(j<k){
                int s = nums[i] + nums[j]+nums[k];
                if(s<target){
                    ans+=(k-j);
                    j++;
                }else{
                    k--;
                }
            }
            i++;
        }
        return ans;
    }
}