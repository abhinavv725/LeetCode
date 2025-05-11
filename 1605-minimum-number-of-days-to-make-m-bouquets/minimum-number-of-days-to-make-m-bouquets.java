class Solution {
    private boolean canMake(int day, int[] bloom, int m, int k){
        int total=0, curr=0;
        for(int i=0;i<bloom.length;i++){
            if(day>=bloom[i]){
                curr++;
                if(curr==k){
                    total++;
                    curr=0;
                }
            }else{
                curr=0;
            }
        }
        return total>=m;
    }
    public int minDays(int[] bloom, int m, int k) {
        int start = Arrays.stream(bloom).min().getAsInt();
        int end = Arrays.stream(bloom).max().getAsInt();
        if((long)(m*k)>bloom.length)    return -1;
        int ans=-1;
        while(start<=end){
            int mid = (start+end)/2;
            if(canMake(mid, bloom, m,k)){
                ans=mid;
                end=mid-1;
            }else{
                start=mid+1;
            }
        }
        return ans;
    }
}