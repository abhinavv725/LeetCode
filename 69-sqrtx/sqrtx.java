class Solution {
    public int mySqrt(int x) {
        
        int l=0,r=x,mid=0,ans=0;
        
        while(l<=r){
            mid=l+(r-l)/2;
            if((long)mid*mid<=(long)x){
                ans=mid;
                l=mid+1;
            }else if((long)mid*mid > (long)x){
                r=mid-1;
            }
        }
        return ans;
    }
}