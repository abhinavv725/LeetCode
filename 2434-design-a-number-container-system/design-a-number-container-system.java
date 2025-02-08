class NumberContainers {

    HashMap<Integer, Integer> m1;
    HashMap<Integer, PriorityQueue<Integer>> m2;

    public NumberContainers() {
        m1 = new HashMap<>();
        m2 = new HashMap<>();
    }
    
    public void change(int index, int number) {
        if(m1.containsKey(index) && m1.get(index)==number)
            return;
        m1.put(index, number);
        m2.putIfAbsent(number, new PriorityQueue<>());
        m2.get(number).add(index);

    }
    
    public int find(int number) {
        if(!m2.containsKey(number))
            return -1;
        PriorityQueue<Integer> pq = m2.get(number);
        while(!pq.isEmpty() && m1.get(pq.peek())!=number)
            pq.poll();
        return pq.isEmpty()?-1: pq.peek();
    }
}

/**
 * Your NumberContainers object will be instantiated and called as such:
 * NumberContainers obj = new NumberContainers();
 * obj.change(index,number);
 * int param_2 = obj.find(number);
 */