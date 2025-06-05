
class Logger {
    HashMap<String, Integer> map;

    public Logger() {
        map = new HashMap<>();
    }
    
    public boolean shouldPrintMessage(int timestamp, String message) {
        if(!map.containsKey(message)){
            map.put(message, timestamp);
            return true;
        }else{
            int time = map.get(message);
            if(timestamp - time < 10){
                return false;
            }
            map.put(message, timestamp);
            return true;
        }
    }
}
