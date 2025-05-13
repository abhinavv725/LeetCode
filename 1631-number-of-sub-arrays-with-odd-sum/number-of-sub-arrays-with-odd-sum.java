class Solution {
    int MOD = (int) 1e9+7;
    public int numOfSubarrays(int[] arr) {
        int sum=0,ans=0;
        int[]pre = new int[arr.length];
        pre[0] = arr[0];
        int cO= 0, cE=1;
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
            if(sum%2==0){
                ans = (ans+cO)%MOD;
                cE++;
            }else{
                ans = (ans+cE)%MOD;
                cO++;
            }
        }
        return ans;
    }
}