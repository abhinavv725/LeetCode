class Solution {
    public int findNumbers(int[] nums) {
        int ans=0;
        for(int i: nums){
            ans += (Integer.toString(i).length()%2==0) ? 1: 0;
        }
        return ans;
    }
}