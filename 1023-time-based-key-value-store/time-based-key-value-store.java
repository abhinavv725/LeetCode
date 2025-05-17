class TimeMap {
    private class Pair {
        int time;String val;
        Pair(String val, int time){
            this.val=val;
            this.time=time;
        }
    }
    HashMap<String, List<Pair>> map ;

    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(!map.containsKey(key)){
            map.put(key, new ArrayList<>());
        }
        map.get(key).add(new Pair(value, timestamp));
        
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key))
            return "";
        List<Pair> pairs = map.get(key);
        int l=0, r=pairs.size()-1;

        while(l<=r){
            int mid = (l+r)/2;
            if(pairs.get(mid).time>timestamp){
                r=mid-1;
            }else{
                l=mid+1;
            }
        }
        if(r==-1)
            return "";
        return pairs.get(r).val;
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */