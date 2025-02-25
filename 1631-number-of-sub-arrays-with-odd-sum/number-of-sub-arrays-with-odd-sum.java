class Solution {
    
    
    public int numOfSubarrays(int[] arr) {
        int ans=0;
        int MOD = (int) Math.pow(10,9)+7;

        int n =arr.length;
        int even=1, odd=0, sum=0;
        for(int i=0;i<n;i++){
            sum+=arr[i];
            if(sum%2==0){
                ans= (ans+odd)%MOD;
                even++;
            }else{
                ans= (ans+even)%MOD;

                odd++;
            }
        }

        return ans%MOD;

    }
}