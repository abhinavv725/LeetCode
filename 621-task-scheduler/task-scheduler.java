class Solution {
    
    public int leastInterval(char[] tasks, int n) {
        int[] arr = new int[26];
        for(char c:tasks){
            arr[c-'A']++;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)-> Integer.compare(b,a));
        for(int i=0;i<26;i++){
            if(arr[i]>0){
                pq.add(arr[i]);
            }
        }
        Queue<int[]> q = new LinkedList<>();
        int time=0;
        while(!pq.isEmpty() || !q.isEmpty()){
            time++;
            while(!q.isEmpty() && q.peek()[1]==time){
                pq.add(q.poll()[0]);
            }
            if(!pq.isEmpty()){
                int curr = pq.poll();
                if(curr==1)
                    continue;
                else{
                    q.add(new int[] {curr-1, time+n+1});

                }
            }

        }
        return time;

    }
}