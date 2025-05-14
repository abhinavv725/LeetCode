class Solution {
    public int maxProduct(int[] nums) {
        int maxi=1, mini=1;
        int res = Arrays.stream(nums).max().getAsInt();
        for(int n:nums){
            if(n==0){
                maxi=1; mini=1;
            }else{
                int temp=maxi;
                maxi = Math.max(n, Math.max(maxi*n, mini*n));
                mini = Math.min(n, Math.min(temp*n, mini*n));
                res=Math.max(res, maxi);
            }
            
        }
        return res;
    }
}