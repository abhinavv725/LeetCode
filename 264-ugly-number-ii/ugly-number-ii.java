class Solution {
    public int nthUglyNumber(int n) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        HashSet<Long> seen =new HashSet<>();
        pq.add(1L);
        seen.add(1L);
        long curr=0;
        while(n-- >0 ){
            curr = pq.poll();

            if(!seen.contains(2*curr)){
                pq.add(2*curr);
                seen.add(2*curr);
            }
            if(!seen.contains(3*curr)){
                pq.add(3*curr);
                seen.add(3*curr);
            }if(!seen.contains(5*curr)){
                pq.add(5*curr);
                seen.add(5*curr);
            }
        }
        return  (int)curr;
    }
}