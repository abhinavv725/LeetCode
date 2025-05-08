class Pair{
    String val;
    int time;
    Pair(String val, int time){
        this.val=val;
        this.time=time;
    }
}
class TimeMap {
    HashMap<String, List<Pair>> map;
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
        if(map.containsKey(key)){
            List<Pair> pairs= map.get(key);
            int l=0;
            int r = pairs.size()-1;

            while(l<=r){
                int mid = (r+l)/2;
                if(pairs.get(mid).time> timestamp){
                    r=mid-1;
                }else{
                    l=mid+1;
                }
            }
            if(r==-1)
                return "";
            return pairs.get(r).val;

        }
        return "";
        
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */