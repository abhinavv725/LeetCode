class Solution {
    
    public String reverseWords(String s) {
        String[] arr = s.split(" ");
        List<String> st = new ArrayList<>();
        for(String a: arr){
            if(a.equals(""))    continue;
            st.add(a);
        }
        Collections.reverse(st);
        return String.join(" ", st);
    }
}