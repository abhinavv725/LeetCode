class CustomStack {
    ArrayList<Integer> arr;
    int capacity;
    int currSize;

    public CustomStack(int maxSize) {
        this.capacity = maxSize;
        arr = new ArrayList<>();
        currSize=0;
    }
    
    public void push(int x) {
        if(currSize == capacity)    
            return;
        arr.add(x);
        currSize++;
    }
    
    public int pop() {
        if(currSize==0)
            return -1;
        int lastEle = arr.get(currSize-1);
        arr.remove(currSize-1);
        currSize--;
        return lastEle;
    }
    
    public void increment(int k, int val) {
        for(int i=0;i<Math.min(currSize, k);i++){
            arr.set(i, arr.get(i)+val);
        }
        
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */