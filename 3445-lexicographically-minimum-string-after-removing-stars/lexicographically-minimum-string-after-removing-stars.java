class Solution {
    public String clearStars(String s) {
        TreeMap<Character, LinkedList<Integer>> indices= new TreeMap<>();
        char[] letters= s.toCharArray();

        for(int i=0; i< s.length(); i++){
            char c= s.charAt(i);
            if(c == '*'){
                char toBeRemoved= indices.firstKey();
                LinkedList<Integer> charIndexes= indices.get(toBeRemoved);
                letters[charIndexes.peekLast()]= '*';
                charIndexes.removeLast();
                if(charIndexes.size() == 0)
                    indices.remove(toBeRemoved);
            }else{
                indices.computeIfAbsent(c, val->new LinkedList<>()).add(i);
            }
        }
        
        return (new String(letters)).replace("*","");
    }
}