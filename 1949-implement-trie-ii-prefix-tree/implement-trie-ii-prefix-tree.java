class Node{
    Node[] links;
    boolean flag;
    int endWith;
    int countPre;

    Node(){
        links = new Node[26];
        flag=false;
        endWith=0;
        countPre=0;
    }
    boolean containsKey(char ch){
        return links[ch-'a']!=null;
    }
    void put(char ch, Node node){
        links[ch-'a'] = node;
    }
    Node get(char ch){
        return links[ch-'a'];
    }
    void setEnd(){
        flag=true;
        endWith++;
    }
    boolean isEnd(){
        return flag;
    }

}
class Trie {
    Node root;

    public Trie() {
        root=new Node();
    }
    
    public void insert(String word) {
        Node node = root;
        for(int i=0;i<word.length();i++){
            char ch = word.charAt(i);
            if(!node.containsKey(ch)){
                node.put(ch, new Node());
            }
            node = node.get(ch);
            node.countPre++;
        }
        node.setEnd();
    }
    
    public int countWordsEqualTo(String word) {
        Node node = root;
        for(int i=0;i<word.length();i++){
            char ch = word.charAt(i);
            if(!node.containsKey(ch)){
                return 0;
            }
            node=node.get(ch);
        }
        return node.endWith;
    }
    
    public int countWordsStartingWith(String prefix) {
        Node node = root;
        for(int i=0;i<prefix.length();i++){
            char ch = prefix.charAt(i);
            if(!node.containsKey(ch)){
                return 0;
            }
            node=node.get(ch);
        }
        return node.countPre;
    }
    
    public void erase(String word) {
        if(countWordsEqualTo(word)==0)
            return;
        
        Node node = root;
        for(int i=0;i<word.length();i++){
            char ch = word.charAt(i);
            node=node.get(ch);
            node.countPre--;
        }
        node.endWith--;
        
        
    }
}
