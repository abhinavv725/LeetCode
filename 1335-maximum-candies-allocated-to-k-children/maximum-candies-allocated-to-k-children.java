class Solution {
    public int maximumCandies(int[] candies, long k) {
        int maxi=Integer.MIN_VALUE, sum=0;
        for(int i=0;i<candies.length;i++){
            sum+=candies[i];
            maxi=Math.max(maxi, candies[i]);
        }
        
        int l=0, r=maxi;
        while(l<r){
            int mid = (l+r+1)/2;
            if(canAllocate(candies, k, mid)){
                l=mid;
            }else{
                r=mid-1;
            }
        }
        return l;
    }
    private boolean canAllocate(int[] candies, long k, int mid){
        long child=0;

        for(int cand: candies){
            child+= cand/mid;
        }
        return child>=k;
    }
}