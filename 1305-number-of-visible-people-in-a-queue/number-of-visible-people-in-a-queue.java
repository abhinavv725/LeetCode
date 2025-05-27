class Solution {
    public int[] canSeePersonsCount(int[] heights) {

        int[] ans = new int[heights.length];
        int n = heights.length;
        Stack<Integer> st = new Stack<>();
        for(int i=n-1;i>=0;i--){
            int c = 0;
            int currH = heights[i];
            while(!st.isEmpty() && currH > st.peek()){
                c++;
                st.pop();
            }
            if(!st.isEmpty()){
                c++;
            }
            ans[i] = c;
            st.push(currH);
        }
        return ans;
        // for(int i=0;i<n-1;i++){
        //     int count =0, h = heights[i+1];
        //     for(int j=i+1;j<n;j++){
        //         if(heights[j] >= h ){
        //             count++;
        //             h = Math.max(h, heights[j]);
        //         }
        //         if(heights[j]>=heights[i]){
        //             break;
        //         }

        //     }
        //     ans[i] = count;
        // }
        // return ans;
    }
}