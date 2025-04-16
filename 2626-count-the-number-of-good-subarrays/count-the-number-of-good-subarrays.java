class Solution {
    public long countGood(int[] nums, int k) {
        Map<Integer, Integer> freq  = new HashMap<>();
        int left=0, right=0;
        long pairs = 0;
        long res = 0;
        int n=nums.length;
        
        while(right<n){
            pairs += freq.getOrDefault(nums[right], 0);
            freq.put(nums[right],freq.getOrDefault(nums[right], 0)+1);

            while(pairs>=k){
                res+=(n-right);
                freq.put(nums[left], freq.get(nums[left])-1);
                pairs -= freq.get(nums[left]);
                left++;
            }
            right++;
        }
        return res;
    }
}