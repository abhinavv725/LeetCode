class Solution {
    private int sum(int n){
        int ans=0;
        while(n!=0){
            ans+=n%10;
            n=n/10;
        }
        return ans;
    }
    public int maximumSum(int[] nums) {
        HashMap<Integer, PriorityQueue<Integer>> map = new HashMap<>();

        for(int i=0;i<nums.length;i++){
            int x = sum(nums[i]);
            PriorityQueue pq = map.getOrDefault(x, new PriorityQueue<>());
            pq.add(nums[i]);
            if(pq.size()>=3){
                pq.poll();
            }
            map.put(x, pq);
        }
        int ans=-1;
        for(PriorityQueue pq: map.values()){
            if(pq.size()>=2){
                int temp =0 ;
                PriorityQueue<Integer> tempPQ = new PriorityQueue<>(pq);
                while(!tempPQ.isEmpty()){
                    temp+=tempPQ.poll();
                }   
                ans=Math.max(ans, temp);
            }
            
        }
        return ans;
        

    }
}