class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> ans = new ArrayList<>();
        HashMap<Character, Integer> last = new HashMap<>();
        for(int i=0;i<s.length();i++){
            last.put(s.charAt(i), i);
        }
        int i=0, prev=-1;
        while(i<s.length()){
            char curr = s.charAt(i);
            int lastIndex = last.get(curr);
            int j=i;
            while(j!=lastIndex){
                char temp =s.charAt(j);
                lastIndex = Math.max(lastIndex, last.get(temp));
                j++;
            }

            ans.add(j-i+1);
            i=j+1;
        }



        return ans;
    }
}