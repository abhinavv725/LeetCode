class RandomizedSet {
    List<Integer> arr;
    HashMap<Integer, Integer> map;
    Random random;

    public RandomizedSet() {
        arr= new ArrayList<>();
        map = new HashMap<>();
        random = new Random();
        
    }
    
    public boolean insert(int val) {
        if(map.containsKey(val))
            return false;
        
        map.put(val, arr.size());
        arr.add(val);
        return true;
    }
    
    public boolean remove(int val) {
        if(!map.containsKey(val)){
            return false;
        }
        int idxToBeRemoved = map.get(val);
        int lastVal = arr.get(arr.size()-1);
        int lastIdx = map.get(arr.get(arr.size()-1));
        map.put(lastVal, idxToBeRemoved);
        arr.set(idxToBeRemoved, lastVal);
        arr.remove(arr.size()-1);
        map.remove(val);

        return true;
        
    }
    
    public int getRandom() {
        return arr.get(random.nextInt(arr.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */