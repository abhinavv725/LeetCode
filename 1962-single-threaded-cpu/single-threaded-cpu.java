class Solution {
    public int[] getOrder(int[][] tasks) {
        int n = tasks.length;
        int[][] taskTime = new int[n][3];
        for(int i=0;i<n;i++){
            taskTime[i][0] = tasks[i][0]; //enqueue
            taskTime[i][1] = tasks[i][1]; // processing time
            taskTime[i][2] = i; // index
        }
        Arrays.sort(taskTime, (a, b)->Integer.compare(a[0], b[0]));
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a,b) -> (a[1]==b[1]) ? 
                Integer.compare(a[2], b[2]) : 
                Integer.compare(a[1], b[1])
        );
        int[] result = new int[n];
        int idx=0, time=0, i=0;

        while(i<n || !pq.isEmpty()){
            while(i<n && taskTime[i][0]<=time){
                pq.add(taskTime[i]);
                i++;
            }
            if(!pq.isEmpty()){
                int[] curr = pq.poll();
                result[idx++] = curr[2];
                time+=curr[1];
            }else{
                time=taskTime[i][0];
            }
        }
        return result;
    }
}