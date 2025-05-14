class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] left = new int[n];   // Index of nearest smaller to the left
        int[] right = new int[n];  // Index of nearest smaller to the right

        Stack<Integer> stack = new Stack<>();

        // Compute nearest smaller to left for each bar
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            left[i] = stack.isEmpty() ? -1 : stack.peek();  // -1 means no smaller to left
            stack.push(i);
        }

        stack.clear();  // Reuse stack

        // Compute nearest smaller to right for each bar
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            right[i] = stack.isEmpty() ? n : stack.peek();  // n means no smaller to right
            stack.push(i);
        }

        // Calculate max area using left and right bounds
        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            int width = right[i] - left[i] - 1;  // Width between nearest smaller elements
            int area = heights[i] * width;
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }
}
