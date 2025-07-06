class Solution {
    private boolean dfs(int i, int n){
        if(n==0){
            return true;
        }
        if(n<0) return false;
        int x = (int) Math.pow(3, i);
        boolean ans=false;
        ans |= dfs(i+1, n-x);
        if(x<n)
            ans |= dfs(i+1, n);

        return ans;

    }
    public boolean checkPowersOfThree(int n) {
        return dfs(0, n);
    }
}