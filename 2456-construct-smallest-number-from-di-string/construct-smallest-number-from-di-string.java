class Solution {
    public String smallestNumber(String pattern) {
        StringBuilder sb = new StringBuilder();
        Stack<Integer> st = new Stack<>();
        int n = pattern.length();
        for(int i=0;i<=n;i++){
            st.push(i+1);
            if(i==n || pattern.charAt(i)=='I'  ){
                while(!st.isEmpty()){
                    sb.append(st.pop());
                }
            }
        }
        return sb.toString();
    }
}