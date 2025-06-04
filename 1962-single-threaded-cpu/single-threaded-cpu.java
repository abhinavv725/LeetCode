class Solution {
    public int[] getOrder(int[][] tasks) {
        int n = tasks.length;
        int[] ans = new int[n];
        int time=0;
        int[][] arr = new int[n][3];
        for(int i=0;i<n;i++){
            int[] t = tasks[i];
            arr[i][0] = t[0]; //enqueue
            arr[i][1] = t[1]; //processing
            arr[i][2] = i; //index
        }
        Arrays.sort(arr,(a, b)-> Integer.compare(a[0], b[0]));
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)-> {
            if(a[1]==b[1]){
                return Integer.compare(a[2], b[2]);
            }
            return Integer.compare(a[1], b[1]);
        });
        int i =0, idx=0;
        while(i<n || !pq.isEmpty()){
            while(i<n && time>= arr[i][0]){
                pq.add(arr[i]);
                i++;
            }
            if(!pq.isEmpty()){
                int[] curr = pq.poll();
                ans[idx++] = curr[2];

                time += curr[1];
            }else{
                time=arr[i][0];
            }
        }
        return ans;
    }
}