class Solution {
    public List<Long> minOperations(int[] nums, int[] queries) {
        Arrays.sort(nums);
        int n = nums.length;
        
        // Long prefix sum for accurate calculations
        long[] prefixSum = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }
        
        List<Long> ans = new ArrayList<>();
        for (int q : queries) {
            int idx = lowerBound(nums, q);
            long leftOps = 1L * q * idx - prefixSum[idx];
            long rightOps = prefixSum[n] - prefixSum[idx] - 1L * q * (n - idx);
            ans.add(leftOps + rightOps);
        }
        
        return ans;
    }

    private int lowerBound(int[] nums, int target) {
        int lo = 0, hi = nums.length;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] < target) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }
}
