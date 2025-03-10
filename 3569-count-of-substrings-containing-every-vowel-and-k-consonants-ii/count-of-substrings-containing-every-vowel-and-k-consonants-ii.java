class Solution {
    private boolean isVowel(char a){
        return a=='a' || a=='e' || a=='i' || a=='o' || a=='u';
    }
    private long atLeastk(String word, int k){
        long ans =0;
        int start=0, end=0;
        HashMap<Character, Integer> map = new HashMap<>();
        int consta=0;
        while(end<word.length()){
            char newV = word.charAt(end);
            if(isVowel(newV)){
                map.put(newV, map.getOrDefault(newV, 0)+1);
            }else{
                consta++;
            }
            while(map.size()==5 && consta>=k){
                ans+=word.length()-end;
                char old = word.charAt(start);
                if(isVowel(old)){
                    map.put(old, map.get(old)-1);
                    if(map.get(old)==0){
                        map.remove(old);
                    }
                }else{
                    consta--;
                }
                start++;
            }
            end++;

        }
        return ans;
    }
    public long countOfSubstrings(String word, int k) {
        
        return atLeastk(word, k) - atLeastk(word, k+1);

    }
}