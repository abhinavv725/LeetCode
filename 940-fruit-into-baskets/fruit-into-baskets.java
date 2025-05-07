class Solution {
    public int totalFruit(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int l=0, ans=0;
        for(int r=0;r<nums.length;r++){
            map.put(nums[r], map.getOrDefault(nums[r], 0)+1);
            while(l<=r && map.size()>2){
                map.put(nums[l], map.get(nums[l])-1);
                if(map.get(nums[l])==0){
                    map.remove(nums[l]);
                }
                l++;
            }

            // if(map.size()==2){
            ans = Math.max(ans, r-l+1);
            // }

        }
        return ans;
        
    }
}