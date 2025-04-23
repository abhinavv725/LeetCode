class Solution {
    private int check(int n){
        int ans=0;
        while(n!=0){
            ans+=(n%10);
            n=n/10;
        }
        return ans;
    }
    public int countLargestGroup(int n) {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        int longest=0;
        for(int i=1;i<=n;i++){
            int x = check(i);
            if(!map.containsKey(x)){
                map.put(x, new ArrayList<>());
            }
            map.get(x).add(i);
            longest = Math.max(longest, map.get(x).size());
        }
        int ans=0;
        for(Integer key: map.keySet()){
            if(map.get(key).size()==longest){
                ans++;
            }
        }
        return ans;
    }
}