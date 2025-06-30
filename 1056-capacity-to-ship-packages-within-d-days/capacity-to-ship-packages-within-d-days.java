class Solution {
    private boolean canBeShipped(int weight, int days, int[] weights){
        int ans=1, temp=0;
        for(int i=0;i<weights.length;i++){
            if(temp+weights[i] <=weight){
                temp+=weights[i];
            }else{
                temp=weights[i];
                ans++;
            }
        }
        return ans<=days;
    }
    public int shipWithinDays(int[] weights, int days) {
        // Arrays.sort(weights);
        int low = Arrays.stream(weights).max().getAsInt();
        int ans=0;
        int high = Arrays.stream(weights).sum();
        while(low<=high){
            int mid = (low+high)/2;
            if(canBeShipped(mid, days, weights)){
                ans = mid;
                high = mid-1;
            }else{
                low=mid+1;
            }
        }
        return ans;
    }
}