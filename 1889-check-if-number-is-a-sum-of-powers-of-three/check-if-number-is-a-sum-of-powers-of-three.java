class Solution {
    private boolean dfs(int i, int n){
        if(n==0)
            return true;
        if(i<0) return false;
        boolean ans =false;
        for(int j=i;j*j*j<=n;j++){
            ans |= dfs(j+1, n-(int)(Math.pow(3, j)));
        }
        return ans;
    }
    public boolean checkPowersOfThree(int n) {
        return dfs(0, n);
    }
}