class Solution {
    
    public int[] maximumBeauty(int[][] items, int[] queries) {
        int maxi = 0;
        Arrays.sort(items, (a, b) -> Integer.compare(a[0], b[0]));
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int[] item: items){
            int price=item[0];
            int beaut = item[1];
            maxi = Math.max(beaut, maxi);
            if(!map.containsKey(price) || map.get(price)<maxi){
                map.put(price, maxi);
            }

        }
        int n = queries.length;
        int[] ans = new int[n];
        for(int i=0;i<n;i++){
            Integer key = map.floorKey(queries[i]);
            ans[i]= key!=null ? map.get(key):0;
        }
        return ans;
        
    }
}