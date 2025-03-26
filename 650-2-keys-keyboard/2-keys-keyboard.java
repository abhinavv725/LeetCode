class Solution {
    private int check(int count, int paste, int n){
        if(count==n)
            return 0;
        if(count>n)
            return 1001;
        
        return Math.min(
            2+check(count*2, count,n),
            1+check(count+paste, paste,n)
        );
    }
    public int minSteps(int n) {
        if(n==1)
            return 0;
        return 1+check(1,1,n);
    }
}