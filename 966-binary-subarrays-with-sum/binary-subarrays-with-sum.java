import java.util.List;

public class Solution {

    // Main method to return number of subarrays with sum exactly equal to 'goal'
    public int numSubarraysWithSum(int[] nums, int goal) {
        // Count of subarrays with sum <= goal minus count with sum <= goal - 1
        // gives count of subarrays with sum == goal
        return countSubarraysWithSumAtMost(nums, goal) - countSubarraysWithSumAtMost(nums, goal - 1);
    }

    // Helper method to count number of subarrays with sum <= x
    private int countSubarraysWithSumAtMost(int[] nums, int x) {
        if (x < 0) return 0; // No subarray can have negative sum in a binary array

        int res = 0;       // Result to store count of valid subarrays
        int left = 0;      // Left pointer of sliding window
        int cur = 0;       // Current sum of the sliding window

        // Iterate with the right pointer
        for (int right = 0; right < nums.length; right++) {
            cur += nums[right]; // Expand the window to the right

            // Shrink the window from the left if sum exceeds x
            while (cur > x) {
                cur -= nums[left];
                left++;
            }

            // All subarrays ending at 'right' and starting between 'left' and 'right' are valid
            res += (right - left + 1);
        }

        return res;
    }
}
