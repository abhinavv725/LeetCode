class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] ans = new int[n];
        int lastEnd=0;
        Stack<Integer> st = new Stack<>();
        for(String log: logs){
            String[] p = log.split(":");
            int idx = Integer.parseInt(p[0]);
            int end = Integer.parseInt(p[2]);
            String func = p[1];
            if(func.equals("start")){
                if(!st.isEmpty()){
                    ans[st.peek()] += end-lastEnd;
                }
                st.push(idx);
                lastEnd = end;
            }else{
                ans[st.pop()] +=  end-lastEnd+1;
                lastEnd = end+1;

            }

        }
        return ans;
    }
}