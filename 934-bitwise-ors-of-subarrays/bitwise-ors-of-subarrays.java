class Solution {
    Set<Integer> set;
    Set<String> seen;
    private void check(int i, int or, int[] arr){
        if(i==arr.length)
            return;
        String key = i+","+or;
        if(seen.contains(key))
            return;
        seen.add(key);
        or |= arr[i];
        set.add(or);
        check(i+1, or, arr);
    }
    public int subarrayBitwiseORs(int[] arr) {
        set=new HashSet<>();
        seen=new HashSet<>();
        for(int i=0;i<arr.length;i++){
            check(i, 0, arr);
        }
        return set.size();
    }
}