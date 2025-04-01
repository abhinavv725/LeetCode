class Solution {
    private int solve(int idx, int[] arr, int d){
        int result=0;
        int prev=arr[idx];
        for(int j=idx+1;j<arr.length;j++){
            int curr = arr[j];
            if(curr-prev==d){
                result = Math.max(result, 1+solve(j, arr, d));
            }
        }
        return result;

    }
    public int longestSubsequence(int[] arr, int d) {
        int result=1;
    //     for(int i=0;i<arr.length;i++){
    //         result = Math.max(result, 1+solve(i, arr, difference));
    //     }
    //     return result;
    
    HashMap<Integer, Integer> map = new HashMap<>();
    for(int i=0;i<arr.length;i++){
        int curr = arr[i];
        if(map.containsKey(curr-d)){
            map.put(curr, map.get(curr-d)+1);
            result = Math.max(result, map.get(curr));
        }else{
            map.put(curr, 1);
            
        }
    }
    return result;
}
}