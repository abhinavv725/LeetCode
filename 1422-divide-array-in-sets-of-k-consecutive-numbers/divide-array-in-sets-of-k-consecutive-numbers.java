class Solution {
    public boolean isPossibleDivide(int[] nums, int k) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int n: nums){
            map.put(n, map.getOrDefault(n, 0)+1);
        }
        while(!map.isEmpty()){
            int key = map.firstKey();
            for(int i = key;i<key+k;i++){
                if(map.containsKey(i)){
                    map.put(i, map.get(i)-1);
                    if(map.get(i)==0){
                        map.remove(i);
                    }
                }else{
                    return false;
                }
            }
        }
        return map.size() == 0;
    }
}