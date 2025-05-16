class Solution {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        // Binary search loop
        while (left <= right) {
            int mid = left + (right - left) / 2; // Avoids potential overflow

            // Case 1: target found at mid
            if (nums[mid] == target) {
                return mid;
            }

            // Determine which half is sorted:
            // Case 2: Left half is sorted
            if (nums[left] <= nums[mid]) {
                // Now check if the target lies within the sorted left half
                if (nums[left] <= target && target < nums[mid]) {
                    // Target is in the left half → eliminate right half
                    right = mid - 1;
                } else {
                    // Target is in the right half → eliminate left half
                    left = mid + 1;
                }
            }

            // Case 3: Right half is sorted
            else {
                // Now check if the target lies within the sorted right half
                if (nums[mid] < target && target <= nums[right]) {
                    // Target is in the right half → eliminate left half
                    left = mid + 1;
                } else {
                    // Target is in the left half → eliminate right half
                    right = mid - 1;
                }
            }
        }

        // Case 4: target was not found
        return -1;
    }
}
