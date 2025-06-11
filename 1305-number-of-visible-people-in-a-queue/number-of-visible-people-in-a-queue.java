class Solution {
    public int[] canSeePersonsCount(int[] heights) {
        int n = heights.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i=n-1;i>=0;i--){
            int count=0;
            while(!st.isEmpty() && heights[i]>=heights[st.peek()]){
                count++;
                st.pop();
            }
            ans[i] = count + (!st.isEmpty() ? 1: 0);
            st.push(i);

        }
        return ans;
    }
}