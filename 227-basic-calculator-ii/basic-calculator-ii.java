class Solution {
    public int calculate(String s) {
        Stack<Integer> st = new Stack<>();
        int num=0;
        char sign = '+';
        s=s+"+";
        for(char c: s.toCharArray()){
            if(c==' ')  continue;
            if(Character.isDigit(c)){
                num =10*num+(c-'0');
                continue;
            }
            if(sign=='-'){
                st.add(-1*num);
            }else if(sign=='+'){
                st.add(num);
            }else if(sign=='*'){
                st.add(st.pop() * num);
            }else{
                st.add(st.pop() / num);
            }
            num=0;
            sign = c;
        }
        int ans=0;
        while(!st.isEmpty()){
            ans+=st.pop();
        }
        return ans;
    }
}