class Solution {
    // Define modulo constant to handle large outputs
    int MOD = (int) 1e9 + 7;

    public int numOfSubarrays(int[] arr) {
        int sum = 0;       // Running prefix sum
        int ans = 0;       // Final answer: number of subarrays with odd sum
        int countOdd = 0;  // Count of prefix sums that are odd
        int countEven = 1; // Count of prefix sums that are even (initial 0-sum is even)

        // Iterate through the array
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];  // Update running sum

            // If current prefix sum is even
            if (sum % 2 == 0) {
                ans = (ans + countOdd) % MOD;  // Odd subarrays end here: even - odd = odd
                countEven++;                   // Increment count of even prefix sums
            } else {
                ans = (ans + countEven) % MOD; // Odd subarrays end here: odd - even = odd
                countOdd++;                    // Increment count of odd prefix sums
            }
        }

        return ans;
    }
}
