class Solution {
    public int minCapability(int[] nums, int k) {
        //Search space. 0 - max possible capacity.
        int lo = 0, hi = Arrays.stream(nums).max().getAsInt();
        
        while(lo + 1 < hi) {
            int mid = lo + (hi - lo) / 2;
            if(canRob(nums, mid, k)) {
                hi = mid;
            }
            else {
                lo = mid;
            }
        }

        return hi;
    }

    private boolean canRob(int[] nums, int capacity, int k) {
        int count = 0;
        for(int i = 0; i < nums.length; i++) {
            //Rob a house if the money is less than current max capacity.
            if(nums[i] <= capacity) {
                count++;
                //skip next house.
                i++;
            }
        }
        //At minimum K houses can be robbed. 
        //so check if it is more than k at given capacity.
        return count >= k;
    }
}