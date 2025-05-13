class Solution {
    int MOD = (int) 1e9+7;
    private int[] findPreviousOrEqual(int[] arr){
        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        int[] nse = new int[n];
        for(int i=0;i<n;i++){

            while(!st.isEmpty() && arr[st.peek()]>arr[i]){
                st.pop();
            }
            nse[i] = st.isEmpty() ? -1: st.peek();
            st.push(i);

        }
        return nse;

    }
    private int[] findNextSmaller(int[] arr){
        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        int[] nse = new int[n];
        for(int i=n-1;i>=0;i--){

            while(!st.isEmpty() && arr[st.peek()]>=arr[i]){
                st.pop();
            }
            nse[i] = st.isEmpty() ? n: st.peek();
            st.push(i);
        }
        return nse;

    }
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int[] psee =findPreviousOrEqual(arr);
        int[] nse = findNextSmaller(arr);
        int result=0;

        for(int i=0;i<n;i++){
            long left = i-psee[i];
            long right = nse[i]-i;

            result =(int) (result + ((arr[i]*left %MOD) * right) %MOD) %MOD;
        } 
        return result;
    }
}