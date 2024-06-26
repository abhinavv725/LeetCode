class Solution {
    public int arrangeCoins(int n) {
        int start=1,count=0;
        while(n>=0){
            count++;
            n-=start;
            start++;
        }
        return count-1;
        
    }
}