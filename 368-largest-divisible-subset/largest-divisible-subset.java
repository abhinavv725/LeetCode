class Solution {
    
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> ans= new ArrayList<>();
        int n=nums.length;
        Arrays.sort(nums);
        List<List<Integer>> dp = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            dp.add(new ArrayList<>(Arrays.asList(nums[i])));
        }
        for(int i=n-1;i>=0;i--){
            for(int j=i+1;j<n;j++){
                if(nums[j]%nums[i]==0){
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.addAll(dp.get(j));
                    if(temp.size()> dp.get(i).size()){
                        dp.set(i, temp);
                    }
                }
            }
            if(ans.size()<dp.get(i).size()){
                ans = dp.get(i);
            }
        }
        
        return ans;
    }
}