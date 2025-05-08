class Solution {
    // Variable to hold the current number to be filled in the grid
    int nums;
    
    // 2D array to store the final answer
    int[][] ans;

    // Recursive function to fill the grid in a specific order
    private void solve(int r, int c, int size){
        // Base case: if size is 1, fill the single cell and return
        if(size == 1){
            ans[r][c] = --nums;
            return;
        }

        // Divide the current square into 4 quadrants of half size
        int n = size / 2;

        // Fill the top-left quadrant
        solve(r, c, n);
        // Fill the bottom-left quadrant
        solve(r + n, c, n);
        // Fill the bottom-right quadrant
        solve(r + n, c + n, n);
        // Fill the top-right quadrant
        solve(r, c + n, n);
    }

    // Public method to initialize and generate the special grid
    public int[][] specialGrid(int n) {
        // Calculate the size of the grid as 2^n
        int size = (int) Math.pow(2, n);

        // Initialize the grid with calculated size
        ans = new int[size][size];

        // Initialize nums to the total number of cells in the grid
        nums = size * size;

        // Start filling the grid from top-left corner
        solve(0, 0, size);

        // Return the filled grid
        return ans;
    }
}
