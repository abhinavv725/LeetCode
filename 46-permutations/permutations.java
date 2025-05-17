 class Solution {
    // This will hold all the permutations
    List<List<Integer>> ans;

    // Recursive DFS function to build permutations
    private void dfs(int[] nums, List<Integer> temp) {
        // Base case: if the temporary list has the same length as input, it's a valid permutation
        if (temp.size() == nums.length) {
            ans.add(new ArrayList<>(temp)); // Add a deep copy to the result
            return;
        }

        // Iterate through each number in the input array
        for (int i = 0; i < nums.length; i++) {
            // Skip the number if it's already used in the current path
            if(temp.contains(nums[i]))  continue;

            // Choose the current number
            temp.add(nums[i]);

            // Explore further with the current number added
            dfs(nums, temp);

            // Backtrack: remove the last number and mark it as unused
            temp.remove(temp.size() - 1);
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        ans = new ArrayList<>(); // Initialize the result list

        dfs(nums, new ArrayList<>()); // Start DFS with an empty list

        return ans; // Return all collected permutations
    }
}
