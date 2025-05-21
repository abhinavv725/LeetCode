class Solution {
    private int getCount(int key, int[] nums){
        int ans=0;
        for(int n: nums){
            if(n==key)  ans++;
        }
        return ans;
    }
    public List<Integer> majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int n: nums){
            map.put(n, map.getOrDefault(n, 0)+1);
            if(map.size()>2){
                HashMap<Integer, Integer> temp = new HashMap<>();

                for(int key: map.keySet()){
                    map.put(key, map.get(key)-1);
                    if(map.get(key)>0){
                        temp.put(key, map.get(key));
                    }
                }
                map=temp;

            }
        }
        List<Integer> ans = new ArrayList<>();

        for(int key: map.keySet()){
            if(getCount(key, nums)> nums.length/3){
                ans.add(key);
            }
        }
        
        return ans;
    }
}