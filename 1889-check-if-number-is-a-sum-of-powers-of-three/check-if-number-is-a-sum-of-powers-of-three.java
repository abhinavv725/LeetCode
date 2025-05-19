class Solution {
    private boolean dfs(int i, int n){
        if(n==0)
            return true;
        if(i<0 || (int)Math.pow(3, i)>n) 
            return false;
        boolean ans =false;
        
        ans |= dfs(i+1, n-(int)(Math.pow(3, i)));
        ans |= dfs(i+1, n);
        return ans;
    }
    public boolean checkPowersOfThree(int n) {
        return dfs(0, n);
    }
}