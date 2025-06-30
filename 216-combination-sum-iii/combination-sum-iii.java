class Solution {
    List<List<Integer>> ans =new ArrayList<>();
    private void check(List<Integer> temp, int sum, int n, int k, int j){
        if(sum == n && temp.size()==k){
            ans.add(new ArrayList<>(temp));
            return;
        }
        if(sum>n || temp.size()>k){
            return;
        }
        for(int i=j+1;i<=9;i++){
            temp.add(i);
            check(temp, sum+i, n, k, i);
            temp.remove(temp.size()-1);
        }

    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        check(new ArrayList<>(),0, n, k, 0);
        return ans;
    }
}