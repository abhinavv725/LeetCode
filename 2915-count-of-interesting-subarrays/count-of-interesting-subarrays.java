class Solution {
    public long countInterestingSubarrays(List<Integer> nums, int m, int k) {
        long ans =0, equal =0;
        Map<Integer, Long> map = new HashMap<>();
        map.put(0, 1L);

        for(int i: nums){
            if(i%m == k)
                equal++;
            int rem = (int) (equal%m);
            int needed = (rem-k +m)%m;
            ans+=map.getOrDefault(needed, 0L);
            map.put(rem, map.getOrDefault(rem, 0L)+1);
        }
        return ans;
    }
}