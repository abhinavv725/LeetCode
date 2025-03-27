class Solution {
    public int minimumIndex(List<Integer> nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0;i<nums.size();i++){
            map.put(nums.get(i), map.getOrDefault(nums.get(i), 0)+1);
        }
        int d =0, df=0;
        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            if(entry.getValue() > df){
                df=entry.getValue();
                d=entry.getKey();
            }
        }
        
        int countLeft=0;
        for(int i=0;i<nums.size();i++){
            if(nums.get(i)==d)
                countLeft++;

            int rightCount = df-countLeft;
            if(countLeft*2 > (i+1) && rightCount*2>(nums.size()-(i+1))){
                return i;
            }
        }
        return -1;
    }
}