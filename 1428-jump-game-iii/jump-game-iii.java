class Solution {
    private ArrayList<Integer> children(int[]arr, int i, HashSet<Integer> set){
        ArrayList<Integer> temp = new ArrayList<>();
        if(i-arr[i]>=0 && set.add(i-arr[i])){
            temp.add(i-arr[i]);
        }
        if(i+arr[i]<arr.length && set.add(i+arr[i])){
            temp.add(i+arr[i]);
        }
        return temp;
    }
    public boolean canReach(int[] arr, int start) {
        Queue<Integer> q= new LinkedList<>();
        HashSet<Integer> set = new HashSet<>();
        q.add(start);
        while(!q.isEmpty()){
            int curr = q.poll();
            for(int i: children(arr, curr, set)){
                if(arr[i]==0){
                    return true;
                }
                
                q.add(i);
            }
        }
        return false;

    }
}