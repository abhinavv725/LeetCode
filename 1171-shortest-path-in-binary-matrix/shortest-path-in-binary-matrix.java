class Solution {
    // Helper method to check if a cell (i, j) is within grid bounds
    private boolean isValid(int i, int j, int n){
        return i >= 0 && j >= 0 && i < n && j < n;
    }

    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;

        // If the starting cell is blocked, no path is possible
        if (grid[0][0] == 1)
            return -1;

        // Special case: single-cell grid that's already open
        if (grid[0][0] == 0 && n == 1)
            return 1;

        // Queue for BFS: each element is an array {row, col, path_length}
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0, 1});

        // Visited matrix to avoid revisiting cells
        boolean[][] vis = new boolean[n][n];
        vis[0][0] = true;

        // Perform BFS
        while (!q.isEmpty()) {
            int size = q.size();

            // Process all nodes at the current BFS level
            while (size-- > 0) {
                int[] curr = q.poll();      // Get current cell
                int row = curr[0], col = curr[1], dist = curr[2];

                // Try moving in all 8 directions
                for (int i = -1; i <= 1; i++) {
                    for (int j = -1; j <= 1; j++) {
                        int ni = row + i;
                        int nj = col + j;

                        // Skip the current cell (i == 0 && j == 0)
                        if (i == 0 && j == 0) continue;

                        // Check bounds, if the cell is not blocked, and not visited
                        if (isValid(ni, nj, n) && grid[ni][nj] == 0 && !vis[ni][nj]) {
                            // Mark as visited
                            vis[ni][nj] = true;

                            // If we reached the bottom-right cell, return the path length
                            if (ni == n - 1 && nj == n - 1) {
                                return dist + 1;
                            }

                            // Add the new cell to the queue with updated path length
                            q.add(new int[]{ni, nj, dist + 1});
                        }
                    }
                }
            }
        }

        // If we exhaust the queue without reaching (n-1, n-1), return -1
        return -1;
    }
}
