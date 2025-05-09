class Solution {
    public String applySubstitutions(List<List<String>> replacements, String text) {
        String ans="";
        boolean check=true;
        HashMap<String, String> map = new HashMap<>();
        for(List<String> s: replacements){
            map.put("%"+s.get(0)+"%", s.get(1));

        }
        while(check){
            check=false;
            for(String key: map.keySet()){
                if(text.contains(key)){
                    text=text.replace(key, map.get(key));
                    check=true;

                }

            }
        }

        return text;
    }
}