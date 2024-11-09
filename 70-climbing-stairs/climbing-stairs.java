class Solution {
    
    public int solve(int n, int[] row){
        if(n==0)return 1;
        if(n<0)return 0;
        if(row[n]!=-1)return row[n];
        
        return row[n]=solve(n-1,row)+solve(n-2,row);
    }
    
    public int climbStairs(int n) {
        int[] row = new int[n+1];
        Arrays.fill(row, -1);
        return solve(n, row);
        
    }
}