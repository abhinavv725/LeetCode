class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        List<Integer> ans = new ArrayList<>();
        int n=nums.length;

        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(i, new ArrayList<>(Arrays.asList(nums[i])));
        }
        for(int i=n-1;i>=0;i--){
            for(int j=i+1;j<n;j++){
                if(nums[j]%nums[i]==0 && map.get(i).size()<=map.get(j).size()){
                    List<Integer> newList = new ArrayList<>();
                    newList.add(nums[i]);
                    newList.addAll(map.get(j));
                    map.put(i, newList);
                }
            }
            if(ans.size()<map.get(i).size()){
                ans = map.get(i);
            }
        }
        return ans;
    }
}