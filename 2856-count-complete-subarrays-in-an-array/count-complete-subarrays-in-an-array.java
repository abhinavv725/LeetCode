class Solution {
    public int countCompleteSubarrays(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i: nums){
            set.add(i);
        }
        int dis = set.size(), n= nums.length, ans=0;
        
        for(int i=0;i<n;i++){
            HashMap<Integer, Integer> map = new HashMap<>();
            for(int j=i;j<n;j++){
                map.put(nums[j], map.getOrDefault(nums[j],0)+1);
                if(map.size()==dis){
                    ans++;
                }

            }
            
        }
        return ans;
        
    }
}