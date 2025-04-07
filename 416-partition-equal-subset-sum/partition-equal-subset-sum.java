class Solution {
    HashMap<String, Boolean> map = new HashMap<>();

    private boolean check(int i,int target, int[] nums){
        if(i==nums.length)
            return false;
        String key = i+"," +target;
        if(map.containsKey(key)){
            return map.get(key);
        }
        if(target==0)
            return true;
        boolean temp = check(i+1, target-nums[i], nums) || check(i+1, target, nums);
        map.put(key, temp);
        return temp;
    }
    public boolean canPartition(int[] nums) {
        int s=0;
        for(int i: nums){
            s+=i;
        }
        if(s%2==1)
            return false;
        return check(0, s/2, nums);
    }
}