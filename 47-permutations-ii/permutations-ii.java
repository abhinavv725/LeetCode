class Solution {
    List<List<Integer>> ans;
    private void check(int[] nums, List<Integer> temp, HashSet<Integer> set){
        if(temp.size()==nums.length){
            if(ans.contains(temp))
                return;
            ans.add(new ArrayList<>(temp));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(set.contains(i))
                continue;
            temp.add(nums[i]);
            set.add(i);
            check(nums, temp, set);
            temp.remove(temp.size()-1);
            set.remove(i);
            
        }
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        ans = new ArrayList<>();
        check(nums, new ArrayList<>(), new HashSet<>());
        return ans;
    }
}