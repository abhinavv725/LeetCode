class Solution {
    public int kthFactor(int n, int k) {
        // Example:
        // n = 30
        // Factors in ascending order = [1, 2, 3, 5, 6, 10, 15, 30]
        // If k = 4 → Expected Output = 5 (the 4th factor)

        int d = 0;

        // First loop: find factors from 1 to sqrt(n)
        for (d = 1; d * d <= n; d++) {
            if (n % d == 0 && --k == 0) {
                return d; // Return d if it's the k-th factor
            }
        }

        // Second loop: find complementary factors greater than sqrt(n)
        for (d = d - 1; d >= 1; d--) {
            // If d * d == n, then we already counted the square root once in the first loop.
            // For example, n = 36 → sqrt(36) = 6; avoid counting 6 again.
            if (d * d == n)
                continue;

            if (n % d == 0 && --k == 0) {
                return n / d; // Return the complementary factor
            }
        }

        // If k is still not zero, it means there are fewer than k factors
        return -1;
    }
}
