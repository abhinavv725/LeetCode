class Solution {

    // Check if (i, j) is within the bounds of the matrix
    private boolean isValid(int i, int j, int n, int m) {
        return i >= 0 && j >= 0 && i < n && j < m;
    }

    // Directions for moving up, left, down, right
    int[][] directions = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

    // DFS to mark all cells that can be reached from (i, j)
    private void dfs(int i, int j, int[][] heights, boolean[][] vis) {
        int n = heights.length;
        int m = heights[0].length;
        vis[i][j] = true;

        // Traverse all 4 directions
        for (int[] dir : directions) {
            int ni = i + dir[0];
            int nj = j + dir[1];

            // Continue DFS if next cell is valid, not visited, and height is >= current (i.e., water can flow)
            if (isValid(ni, nj, n, m) && !vis[ni][nj] && heights[ni][nj] >= heights[i][j]) {
                dfs(ni, nj, heights, vis);
            }
        }
    }

    // Main function to find all coordinates where water can flow to both Pacific and Atlantic oceans
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;

        // Boolean matrices to mark cells reachable from Pacific and Atlantic oceans
        boolean[][] pac = new boolean[n][m];
        boolean[][] atl = new boolean[n][m];

        // Start DFS from the Pacific border (top and left edges)
        for (int i = 0; i < n; i++) {
            if (!pac[i][0]) dfs(i, 0, heights, pac);       // Left column
            if (!atl[i][m - 1]) dfs(i, m - 1, heights, atl); // Right column
        }

        for (int j = 0; j < m; j++) {
            if (!pac[0][j]) dfs(0, j, heights, pac);       // Top row
            if (!atl[n - 1][j]) dfs(n - 1, j, heights, atl); // Bottom row
        }

        // Collect coordinates reachable from both oceans
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (pac[i][j] && atl[i][j]) {
                    ans.add(Arrays.asList(i, j));
                }
            }
        }

        return ans;
    }
}
