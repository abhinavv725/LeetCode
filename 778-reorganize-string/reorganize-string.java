class Solution {
    private class Node {
        char ch;
        int freq;
        Node(char ch, int freq){
            this.ch = ch;
            this.freq=freq;
        }
    }
    public String reorganizeString(String s) {
        PriorityQueue<Node> pq = new PriorityQueue<>(
            (a,b) -> Integer.compare(b.freq, a.freq)
        );
        StringBuilder sb = new StringBuilder();
        int[] charCount = new int[26];
        for(char c : s.toCharArray()){
            charCount[c - 'a']++;
        }
        for(int i=0;i<26;i++){
            if(charCount[i]>0){
                pq.add(new Node((char)(i+'a'), charCount[i]));

            }
        }
        while(!pq.isEmpty()){
            Node one = pq.poll();
            if(pq.isEmpty()){
                if(one.freq==1){
                    sb.append(one.ch);
                    return sb.toString();
                }else{
                    return "";
                }
            }
            Node two = pq.poll();
            sb.append(one.ch);
            sb.append(two.ch);
            one.freq--;
            two.freq--;
            if(one.freq>0){
                pq.add(one);
            }
            if(two.freq>0){
                pq.add(two);
            }
        }
        return sb.toString();
    }
}