class Solution {
    public String removeDuplicateLetters(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++){
            map.put(s.charAt(i), i);
        }
        Stack<Character> st = new Stack<>();
        Set<Character> set = new HashSet<>();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(!set.contains(c)){
                while(st.size()!=0 && c<st.peek() && map.get(st.peek())>i){
                    set.remove(st.pop());
                }
                set.add(c);
                st.push(c);
            }
            
        }
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        return sb.reverse().toString();
    }
}