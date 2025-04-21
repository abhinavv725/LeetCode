class Solution {
    public int numberOfArrays(int[] differences, int lower, int upper) {
        int n = differences.length;
        
        long maxi = 0;
        long mini= 0;
        long sum=0;
        for(int i=0;i<n;i++){
            sum += differences[i];
            maxi =Math.max(maxi, sum);
            mini = Math.min(mini, sum);
        }
        return (int) Math.max(0,(upper-lower)-(maxi-mini)+1); 
        
    }
}