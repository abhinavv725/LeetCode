class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> map = new HashMap<>();
        for(String w: words){
            map.put(w, map.getOrDefault(w, 0)+1);
        }
        PriorityQueue<String> pq= new PriorityQueue<>((a, b) -> {
            if(map.get(a) == map.get(b)){
                return a.compareTo(b);
            }
            return Integer.compare(map.get(b), map.get(a));
        });
        for(String key: map.keySet()){
            pq.add(key);
        }
        List<String> ans = new ArrayList<>();
        while(k-- >0){
            ans.add(pq.poll());
        }
        return ans;
    }
}