class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        List<Integer> ans = new ArrayList<>();
        List<List<Integer>> dp = new ArrayList<>();
        
        for(int n: nums){
            dp.add(new ArrayList<>(Arrays.asList(n)));
        }
        int n = nums.length;
        for(int i=n-1;i>=0;i--){
            for(int j=i+1;j<n;j++){
                if(nums[j]%nums[i]==0){
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.addAll(dp.get(j));

                    if(temp.size()>dp.get(i).size())
                        dp.set(i, temp);
                }
            }
            if(dp.get(i).size()>ans.size()){
                ans = dp.get(i);
            }
        }
        return ans;
    }
}