class Solution {
    private boolean canMake(int day, int[] bloomDay, int m, int k){
        int totalBoq = 0,consecCount=0;
        for(int i=0;i<bloomDay.length;i++){
            if(bloomDay[i]<=day){
                consecCount++; 
            }else{
                consecCount=0;
            }
            if(consecCount==k){
                totalBoq++;
                consecCount=0;

            }
        }

        return totalBoq>=m;
    }
    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        if((long)(m*k)>n){
            return -1;
        }
        int end = Arrays.stream(bloomDay).max().getAsInt();
        int start = Arrays.stream(bloomDay).min().getAsInt();
        int ans=-1;

        while(start<=end){
            int mid = start + (end-start)/2;

            if(canMake(mid,bloomDay, m,k)){
                ans=mid;
                end = mid-1;
            }else{
                start=mid+1;
            }

        }
        return ans;

    }
}