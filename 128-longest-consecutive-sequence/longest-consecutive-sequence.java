class Solution {
    public int longestConsecutive(int[] nums) {
        int ans=0;
        HashSet<Integer> set = new HashSet<>();
        for(int n: nums){
            set.add(n);
        }
        for(int n: set){
            int temp=0, x= n;
            if(!set.contains(x-1)){
                while(set.contains(x)){
                    x++;
                    temp++;
                }
                
            }
            ans=Math.max(ans, temp);
        }

        return ans;
    }
}