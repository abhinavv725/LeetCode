class Solution {
    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings, (a,b) -> Integer.compare(a[0], b[0]));
        PriorityQueue<Integer> free = new PriorityQueue<>();
        int[] arr = new int[n];
        PriorityQueue<long[]> busy = new PriorityQueue<>((a, b) -> {
            if (a[1] == b[1]) return Long.compare(a[0], b[0]);
            return Long.compare(a[1], b[1]);
        });
        for(int i=0;i<n;i++){
            free.add(i);
        }

        int i=0, time=0;
        while(i<meetings.length){
            int[] meet = meetings[i];
            
            int start = meet[0], end =meet[1];
            
            while(!busy.isEmpty() && busy.peek()[1] <= start){
                free.add((int)(busy.poll()[0]));
            }
            if(!free.isEmpty()){
                int room = free.poll();
                arr[room]++;
                busy.add(new long[] {room, end});
            }else{
                long[] nxt = busy.poll();
                int room = (int)nxt[0];
                long newStart = nxt[1];
                long newEnd = newStart+(end-start);
                arr[room]++;
                busy.add(new long[] {room, newEnd});
            }
            i++;
        }
        int max = Arrays.stream(arr).max().getAsInt();
        for( i=0;i<arr.length;i++){
            if(arr[i]==max){
                return i;
            }
        }
        return 0;
    }
}