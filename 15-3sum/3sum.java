class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;
        List<List<Integer>> ans = new ArrayList<>();

        for(int i=0;i<nums.length;i++){
            if(i>0 && nums[i]==nums[i-1]){
                continue;
            }
            int j = i+1, k=n-1;
            while(j<k){
                int a = nums[i], b=nums[j], c=nums[k];
                if(a+b+c==0){
                    ans.add(new ArrayList<>(Arrays.asList(a,b,c)));
                    while(j<k && nums[j]==nums[j+1])
                        j++;
                    while(j<k && nums[k]==nums[k-1])
                        k--;
                    j++;
                    k--;
                }else if(a+b+c>0){
                    k--;
                }else{
                    j++;
                }
                
            }
        }
        return ans;
    }
}