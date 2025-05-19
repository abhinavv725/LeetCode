class Pair {
    char c; int freq;
    Pair(char c, int freq){
        this.c=c;
        this.freq=freq;
    }
}
class Solution {
     
    public String reorganizeString(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(char c: s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> Integer.compare(b.freq, a.freq));
        for(char c: map.keySet()){
            pq.add(new Pair(c, map.get(c)));
        }
        StringBuilder sb = new StringBuilder();
        while(pq.size()>=2){
            Pair first = pq.poll();
            Pair second = pq.poll();
            sb.append(first.c);
            sb.append(second.c);
            if(--first.freq>0)  pq.add(first);
            if(--second.freq>0)  pq.add(second);
        }
        if(!pq.isEmpty()){
            Pair last = pq.poll();
            if(last.freq>1){
                return "";
            }
            sb.append(last.c);
        }
        return sb.toString();


    }
}