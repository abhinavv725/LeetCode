class Solution {
    public int longestConsecutive(int[] nums) {
        int ans=0;
        HashSet<Integer> set = new HashSet<>();
        for(int n: nums){
            set.add(n);
        }
        for(int num: set){
            if(!set.contains(num-1)){
                int temp=0;
                while(set.contains(num)){
                    temp++;
                    num++;
                }
                ans=Math.max(ans, temp);
            }
        }
        return ans;
    }
}