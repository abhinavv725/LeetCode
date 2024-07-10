class Solution {
    public int minOperations(String[] logs) {
        Stack<String> stack = new Stack<>();
        
        for (String st: logs){
            if(st.equals("../")){
                if(!stack.isEmpty())
                    stack.pop();
            }
            else if(!st.equals("./"))
                stack.push(st);
            
        }
        return stack.size();
        
    }
}