class Solution {
    public String minRemoveToMakeValid(String s) {
        boolean[] remove = new boolean[s.length()];
        Stack<Integer> st = new Stack<>();

        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c=='('){
                st.push(i);
            }else if(c==')'){
                if(st.isEmpty()){
                    remove[i]=true;
                }else{
                    st.pop();
                }
            }
        }
        while(!st.isEmpty()){
            remove[st.pop()]=true;
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(remove[i]){
                continue;
            }else{
                sb.append(c);
            }
        }
        return sb.toString();
    }
}