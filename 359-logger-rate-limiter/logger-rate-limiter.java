class Logger {
    Queue<String>q ;
    HashMap<String, Integer> map ;

    public Logger() {
        q = new LinkedList<>();
        map = new HashMap<>();
    }
    
    public boolean shouldPrintMessage(int timestamp, String message) {
        while(!q.isEmpty() && map.get(q.peek())+10<=timestamp){
            map.remove(q.poll());
        }
        if(!map.containsKey(message)){
            q.add(message);
            map.put(message, timestamp);
            return true;
        }
        return false;
        
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */