import java.util.*;

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int n = arr.length;

        // Step 1: Find the position where x would be inserted
        int left = 0, right = n - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (arr[mid] < x) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        // Step 2: Use two pointers to expand outwards from the insert position
        int i = left - 1;  // left pointer
        int j = left;      // right pointer

        // Pick k closest elements
        while (k-- > 0) {
            if (i < 0) {
                j++;  // no more elements on the left
            } else if (j >= n) {
                i--;  // no more elements on the right
            } else if (Math.abs(arr[i] - x) <= Math.abs(arr[j] - x)) {
                i--;  // pick left element if closer or equal
            } else {
                j++;  // pick right element if closer
            }
        }

        // Step 3: Build the result list from (i+1) to (j-1)
        List<Integer> result = new ArrayList<>();
        for (int idx = i + 1; idx < j; idx++) {
            result.add(arr[idx]);
        }

        return result;
    }
}
