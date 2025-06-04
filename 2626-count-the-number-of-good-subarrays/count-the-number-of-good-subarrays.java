class Solution {
    public long countGood(int[] nums, int k) {
        long ans=0, total=0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int l=0;
        for(int r=0;r<nums.length;r++){
            int curr = map.getOrDefault(nums[r], 0);
            total+=curr;
            map.put(nums[r], curr+1);
            while(total>=k){
                ans+=nums.length-r;
                int left = map.get(nums[l]);
                total-=left-1;
                map.put(nums[l], left-1);
                l++;
            }
        }

        return ans;
    }
}