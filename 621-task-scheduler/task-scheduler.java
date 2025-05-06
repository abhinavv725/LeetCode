class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for(char c: tasks){
            freq[c-'A']++;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> Integer.compare(b,a));
        for(int i=0;i<26;i++){
            if(freq[i]>0){
                pq.add(freq[i]);

            }
        }
        int time=0;
        // new int[]{num, time};
        Queue<int[]> q = new LinkedList<>();
        while(!pq.isEmpty() || !q.isEmpty()){
            time++;
            if(!q.isEmpty() && q.peek()[1]==time){
                pq.add(q.poll()[0]);
            }
            if(!pq.isEmpty()){
                int x = pq.poll();
                if(x==1)
                    continue;
                else{
                    q.add(new int[]{x-1, time+n+1});
                }

            }
        }
        return time;
    }
}