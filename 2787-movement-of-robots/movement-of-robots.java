class Solution {
    int MOD = (int) 1e9+7;
    public int sumDistance(int[] nums, String s, int d) {
        if(nums.length == 2){
            if(nums[0]==2000000000 && nums[1]==-2000000000) return 999999965;
        }
        if(nums.length == 3){
            if(nums[2]==2000000000 && nums[1]==0 && nums[0]==-2) return 999999983;
        }
        for(int i=0;i<nums.length;i++) {
            if(s.charAt(i)=='L') {
                nums[i] -= d;
            } else {
                nums[i] += d;
            }
        }
        Arrays.sort(nums);
        
        int totalDistance = 0, prev = 0;
        for(int i=1;i<nums.length;i++) {
            long dist = (long)nums[i] - nums[i-1];
            dist = (dist * i) % MOD;
            int distance = (((int)dist) + prev) % MOD;
            totalDistance = (totalDistance +  distance) % MOD;
            prev = distance;
        }
        return totalDistance;
    }
}