 class Solution {
    // This will hold all the permutations
    List<List<Integer>> ans;

    // Recursive DFS function to build permutations
    private void dfs(int[] nums, List<Integer> temp, boolean[] used) {
        // Base case: if the temporary list has the same length as input, it's a valid permutation
        if (temp.size() == nums.length) {
            ans.add(new ArrayList<>(temp)); // Add a deep copy to the result
            return;
        }

        // Iterate through each number in the input array
        for (int i = 0; i < nums.length; i++) {
            // Skip the number if it's already used in the current path
            if (used[i]) continue;

            // Choose the current number
            used[i] = true;
            temp.add(nums[i]);

            // Explore further with the current number added
            dfs(nums, temp, used);

            // Backtrack: remove the last number and mark it as unused
            temp.remove(temp.size() - 1);
            used[i] = false;
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        ans = new ArrayList<>(); // Initialize the result list

        boolean[] used = new boolean[nums.length]; // Tracks used numbers by index

        dfs(nums, new ArrayList<>(), used); // Start DFS with an empty list

        return ans; // Return all collected permutations
    }
}
