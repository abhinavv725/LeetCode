class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        HashMap<Character, Integer> map = new HashMap<>();

        for(int i=0;i<order.length();i++){
            map.put(order.charAt(i),i);
        }
        for(int i=1;i<words.length;i++){
            String wordA = words[i-1];
            String wordB = words[i];

            for(int j=0;j<wordA.length();j++){
                if(j==wordB.length()){
                    return false;
                }
                char ca = wordA.charAt(j);
                char cb = wordB.charAt(j);
                if(map.get(ca)<map.get(cb))
                    break;
                if(map.get(ca)>map.get(cb))
                    return false;
            }
        }
        return true;
    }
}