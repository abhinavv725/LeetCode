class Solution {
    public String decodeString(String s) {
        StringBuilder sb = new StringBuilder();
        Stack<Integer> countStack = new Stack<>();
        Stack<StringBuilder> stringStack = new Stack<>();
        StringBuilder curr = new StringBuilder();
        int k=0;
        for(char ch: s.toCharArray()){
            if(Character.isDigit(ch)){
                k=k*10 + (ch-'0');
            }else if(ch =='['){
                countStack.push(k);
                stringStack.push(curr);
                curr=new StringBuilder();
                k=0;
            }else if(ch == ']'){
                int multiplier = countStack.pop();
                StringBuilder decoded = stringStack.pop();
                for(int i=0;i<multiplier;i++){
                    decoded.append(curr);
                }
                curr=decoded;

            }else{
                curr.append(ch);
            }
        }
        return curr.toString();

        
    }
}