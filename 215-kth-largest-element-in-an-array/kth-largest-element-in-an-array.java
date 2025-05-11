class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->Integer.compare(b,a));
        for(int n: nums){
            pq.add(n);
        }
        while(k-- >1){
            pq.poll();
        }
        return pq.poll();

    }
}