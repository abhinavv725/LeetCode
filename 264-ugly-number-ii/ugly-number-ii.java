class Solution {
    public int nthUglyNumber(int n) {
        TreeSet<Long> ts = new TreeSet<>();
        ts.add(1L);
        long curr=0;
        while(n-- >0 ){
            curr = ts.pollFirst();
            ts.add(curr*2);
            ts.add(curr*3);
            ts.add(curr*5);
        }
        return  (int)curr;
    }
}