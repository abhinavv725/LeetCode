class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        int n=arr.length;
        HashMap<Integer, Integer> dp = new HashMap<>();
        int ans=1;
        for(int a:arr){
            int before_a = a-difference;
            int len = dp.getOrDefault(before_a, 0)+1;
            dp.put(a, len);
            ans = Math.max(ans, len);
        }
        return ans;
    }
}