class Solution {
    private int count(int[] nums,int k){
        HashMap<Integer, Integer> map = new HashMap<>();
        int ans=0, l=0;
        for(int r=0;r<nums.length;r++){
            map.put(nums[r], map.getOrDefault(nums[r], 0)+1);
            while(l<=r &&  map.size()>k){
                map.put(nums[l], map.get(nums[l])-1);
                if(map.get(nums[l])==0){
                    map.remove(nums[l]);
                }
                l++;
            }

            ans +=r-l+1;
        }

        return ans;

    }

    public int subarraysWithKDistinct(int[] nums, int k) {
        return count(nums, k) - count(nums, k-1);
    }
}