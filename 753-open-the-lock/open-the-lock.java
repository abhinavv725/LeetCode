class Solution {
    private List<String> children(String lock){
        List<String> result = new ArrayList<>();
        for(int i=0;i<4;i++){
            char[] arr  = lock.toCharArray();
            arr[i] = (char) ((arr[i]-'0' + 1)%10 + '0');
            result.add(new String(arr));

            arr=lock.toCharArray();
            arr[i] = (char) ((arr[i]-'0' - 1 +10)%10 + '0');
            result.add(new String(arr));
        }

        return result;
        
    }
    public int openLock(String[] deadends, String target) {
        Set<String> visited = new HashSet<>(Arrays.asList(deadends));
        if(visited.contains("0000"))
            return -1;
        
        Queue<String> q = new LinkedList<>();
        q.add("0000");
        visited.add("0000");
        int turns=0;
        while(!q.isEmpty()){
            int size = q.size();
            while(size-->0){
                String lock = q.poll();
                if(lock.equals(target))
                    return turns;
                
                for(String next: children(lock)){
                    if(!visited.contains(next)){
                        visited.add(next);
                        q.add(next);
                    }
                }
            }
            turns++;
        }
        return -1;
    }
}