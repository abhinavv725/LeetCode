class Solution {
    int sum;
    Random random;
    int[] arr;

    public Solution(int[] w) {
        int len = w.length;
        arr = new int[len];
        sum=0;
        for(int i=0;i<len;i++){
            sum+=w[i];
            arr[i] = sum;
        }
        random = new Random();
        
    }
    
    public int pickIndex() {
        int randNumber = random.nextInt(sum)+1;
        int idx = Arrays.binarySearch(arr, randNumber);
        if(idx<0){
            idx = -idx-1;
        }
        return idx;

        
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */