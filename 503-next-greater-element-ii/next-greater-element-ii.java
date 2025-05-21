class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Stack<Integer> st = new Stack<>();

        // Initialize result with -1
        Arrays.fill(res, -1);

        // Traverse the array twice in reverse to simulate circularity
        for (int i = 2 * n - 1; i >= 0; i--) {
            int index = i % n;

            // Pop elements from stack that are smaller than or equal to current
            while (!st.isEmpty() && nums[st.peek()] <= nums[index]) {
                st.pop();
            }

            // If stack is not empty, the top is the next greater element
            if (!st.isEmpty()) {
                res[index] = nums[st.peek()];
            }

            // Push current index onto the stack
            st.push(index);
        }

        return res;
    }
}
