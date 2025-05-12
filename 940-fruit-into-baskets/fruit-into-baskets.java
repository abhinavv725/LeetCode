class Solution {
    public int totalFruit(int[] fruits) {
        int ans=0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int l=0;
        for(int r=0;r<fruits.length;r++){
            map.put(fruits[r], map.getOrDefault(fruits[r], 0)+1);
            while(l<=r && map.size()>2){
                map.put(fruits[l], map.get(fruits[l])-1);
                if(map.get(fruits[l])==0){
                    map.remove(fruits[l]);
                }
                l++;

            }
            ans = Math.max(ans, r-l+1);
        }

        return ans;
    }
}