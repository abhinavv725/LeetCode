class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n*2];
        int[] res = new int[n];
        Arrays.fill(res, -1);
        for(int i=0;i< (2*n);i++){
            arr[i] = nums[i%n];
        }
        // 1  2 1 1  2  1
        // 2 -1 2 2 -1 -1      

        Stack<Integer> st = new Stack<>();
        for(int i=(2*n)-1;i>=0;i--){
            while(!st.isEmpty() && arr[st.peek()] <= arr[i]){
                st.pop();
            }
            if(i< n && !st.isEmpty()){
                res[i] = arr[st.peek()];
            }
            st.push(i);

        }
        return res;
    }
}