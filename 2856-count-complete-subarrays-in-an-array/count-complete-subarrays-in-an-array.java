class Solution {
    public int countCompleteSubarrays(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int n: nums){
            set.add(n);
        }
        int l=0, ans=0;

        for(int r=0;r<nums.length;r++){
            map.put(nums[r], map.getOrDefault(nums[r], 0)+1);
            while(l<=r && map.size()==set.size()){
                ans+= nums.length-r;
                map.put(nums[l], map.get(nums[l])-1);
                if(map.get(nums[l])==0)
                    map.remove(nums[l]);
                l++;
            }
        }
        return ans;
        
    }
}