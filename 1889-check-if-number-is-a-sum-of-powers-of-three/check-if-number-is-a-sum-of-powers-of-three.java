class Solution {
    private boolean dfs(int i, int n){
        if(n==0){
            return true;
        }
        int x = (int)Math.pow(3, i);
        if(n<0 || x>n) return false;
        

        return  dfs(i+1, n-(int)(Math.pow(3, i))) || dfs(i+1, n );
    }
    public boolean checkPowersOfThree(int n) {
        return dfs(0, n);
    }
}