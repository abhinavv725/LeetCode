class Solution {
    public String applySubstitutions(List<List<String>> replacements, String text) {
       boolean modify = true;
       while(modify){
            modify=false;
            for(int i=0;i<replacements.size();i++){
                List<String> curr = replacements.get(i);
                String key = "%"+curr.get(0) +"%";
                String value = curr.get(1);
                if(text.contains(key)){
                    text = text.replace(key, value);
                    modify=true;
                }
            }

       }
       return text;
    }
}