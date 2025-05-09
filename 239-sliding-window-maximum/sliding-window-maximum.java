class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(k<=1){
            return nums;
        }
        Deque<Integer> dq = new ArrayDeque<>();
        int n=nums.length;
        int c=0;
        int[] res = new int[n-k+1];
        for(int i=0;i<n;i++){
            while(!dq.isEmpty() && dq.peekFirst()<i-k+1){
                dq.pollFirst();
            }
            while(!dq.isEmpty() && nums[dq.peekLast()]<nums[i]){
                dq.pollLast();
            }
            dq.addLast(i);
            if(i>=k-1){
                res[c++] = nums[dq.peekFirst()];
            }

        }

        return res;
    }
}