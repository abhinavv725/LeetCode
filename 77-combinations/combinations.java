class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    private void combinations(int i,int n, int k,List<Integer> temp){
        if(k==0){
            ans.add(new ArrayList<>(temp));
            return;
        }
        for(int j=i;j<=n;j++){
            temp.add(j);
            combinations(j+1, n, k-1, temp);
            temp.remove(temp.size()-1);
        }
    }
    public List<List<Integer>> combine(int n, int k) {
        combinations(1, n, k, new ArrayList<>());

        return ans;
    }
}