class Solution {
    public int latestTimeCatchTheBus(int[] buses, int[] passengers, int capacity) {
        Arrays.sort(buses);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int p: passengers){
            pq.add(p);
        }
        for(int i=0;i<buses.length-1;i++){
            int temp = capacity;
            while(temp-- >0 && !pq.isEmpty() && pq.peek()<=buses[i]){
                pq.poll();
            }
        }
        int lastBus = buses[buses.length-1];
        List<Integer> lastpassengers = new ArrayList<>();
        int temp = capacity;
        while(temp-- >0 && !pq.isEmpty() && pq.peek()<=lastBus){
            lastpassengers.add(pq.poll());
        }
        Set<Integer> set = new HashSet<>();
        for(int p: passengers){
            set.add(p);
        }
        if(lastpassengers.size()<capacity){
            for(int i=lastBus;i>=0;i--){
                if(!set.contains(i))
                    return i;
            }
        }else{
            int lastPassenger = lastpassengers.get(lastpassengers.size()-1);
            for(int i=lastPassenger-1;i>=0;i--){
                if(!set.contains(i))
                    return i;
            }
        }
        return -1;
    }
}