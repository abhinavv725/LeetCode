class Solution {
    public String removeDuplicateLetters(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++){
            map.put(s.charAt(i), i);
        }
        Stack<Character> st = new Stack<>();
        HashSet<Character> set = new HashSet<>();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(set.contains(c)) continue;
            while(!st.isEmpty() && st.peek() > c && map.get(st.peek()) > i){
                set.remove(st.pop());
            }
            st.push(c);
            set.add(c);
        } 
        StringBuilder sb = new StringBuilder();
        for(char c: st){
            sb.append(c);
        }
        return sb.toString();
    }
}