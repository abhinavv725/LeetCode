class SnapshotArray {
    int idx;
    List<List<int[]>> history;

    public SnapshotArray(int length) {
        idx =0;
        history = new ArrayList<>();
        while(length-- >0){
            history.add(new ArrayList<>());
        }
    }
    
    public void set(int index, int val) {
        List<int[]> snap = history.get(index);
        if(!snap.isEmpty() && snap.get(snap.size()-1)[0]==idx){
            snap.get(snap.size()-1)[1]=val;
        }else{
            snap.add(new int[]{idx, val});
        }
    }
    
    public int snap() {
        return idx++;
    }
    
    public int get(int index, int snap_id) {
        List<int[]> snap = history.get(index);
        int start=0, end = snap.size()-1, nums=0;
        while(start<=end){
            int mid = (start+end)/2;
            if(snap.get(mid)[0]<=snap_id){
                nums=snap.get(mid)[1];
                start=mid+1;
            }else{
                end=mid-1;
            }

        }

        return nums;
    }
}

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */