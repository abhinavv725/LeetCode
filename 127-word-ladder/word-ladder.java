
class Pair{
    String str;
    int steps;
    Pair(String _str,int _steps){
        this.str=_str;
        this.steps=_steps;
    }
}

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> st = new HashSet<String>();
        for(int i=0;i<wordList.size();i++){
            st.add(wordList.get(i));
        }
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(beginWord,1));
        st.remove(beginWord);
        int len = beginWord.length();
        while(!q.isEmpty()){
            String str = q.peek().str;
            int steps= q.peek().steps;
            q.remove();
            if(str.equals(endWord))return steps;
            
            for(int i=0;i<str.length();i++){
                for(char c='a';c<='z';c++){
                    char toBeReplaced[] = str.toCharArray();
                    toBeReplaced[i]=c;
                    String temp = new String(toBeReplaced);
                    // System.out.println(temp);
                    if(st.contains(temp)){
                        q.add(new Pair(temp,steps+1));
                        st.remove(temp);
                    }
                }
            }
            
            
        }
        return 0;
    }
}