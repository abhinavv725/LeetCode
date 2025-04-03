class Solution {
    private int solve(int n, int curr, int screen) {
        if (n == screen) return 0;
        if (screen > n) return 10001; // Fix incorrect return value
        int copy=100001;
        if(curr!=screen){
            copy = 1+solve(n, screen, screen);
        }
        int paste = 1 + solve(n, curr, screen+curr);
        
        return Math.min(copy, paste);
    }

    public int minSteps(int n) {
        if (n == 1) return 0; // Edge case: already has one 'A', no operations needed
        return solve(n ,1, 1)+1; // Fix initial call
    }
}