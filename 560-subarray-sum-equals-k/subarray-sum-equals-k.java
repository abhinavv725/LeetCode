class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        int s=0, ans=0;
        for(int n: nums){
            s+=n;
            if(map.containsKey(s-k)){
                ans+=map.get(s-k);
            }
            map.put(s, map.getOrDefault(s, 0)+1);
        }
        return ans;
    }

}