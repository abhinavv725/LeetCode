class Solution {
    private void fillRight(String s, HashMap<Character, Integer> right){
        for(char c : s.toCharArray()){
            right.put(c, right.getOrDefault(c, 0)+1);
        }

    }
    public int numSplits(String s) {
        HashMap<Character,Integer> left = new HashMap<>();
        HashMap<Character,Integer> right = new HashMap<>();
        int res=0;
        int i=0;
        fillRight(s, right);
        while(i<s.length()){
            if(left.size()==right.size())
                res++;
            
            char curr = s.charAt(i);
            left.put(curr, left.getOrDefault(curr, 0)+1);
            right.put(curr, right.get(curr)-1);
            if(right.get(curr)==0){
                right.remove(curr);
            }
            i++;

        }
        return res;
    }
}