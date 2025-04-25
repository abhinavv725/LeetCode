class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    private void check(int i, int[]arr, int target, List<Integer> temp){
        if(target<0)
            return;
        if(target == 0){
            ans.add(new ArrayList<>(temp));
            return;
        }

        for(int j=i;j<arr.length;j++){
            if(j>i && arr[j]==arr[j-1])
                continue;
            temp.add(arr[j]);
            
            check(j+1, arr, target-arr[j], temp);
            temp.remove(temp.size()-1);

        }

    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        check(0, candidates, target,new ArrayList<>());
        return ans;
    }
}