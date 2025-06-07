class Solution {
    HashMap<Character, String> map = new HashMap<>();
    public String dfs(String text, StringBuilder sb){
        if(text.equals("")) 
            return "";
        char[] arr = text.toCharArray();
        int i=0;
        while(i<arr.length){
            char c = arr[i];
            if(c=='%'){
                char k = arr[i+1];
                i+=2;
                String replace = map.get(k);

                sb.append(dfs(replace, new StringBuilder()));
            }else{
                sb.append(c);
            }
            i++;
        }
        return sb.toString();
    }
    public String applySubstitutions(List<List<String>> replacements, String text) {
        for(List<String> s: replacements){
            map.put(s.get(0).charAt(0), s.get(1));
        }

        return dfs(text, new StringBuilder());
    }
}