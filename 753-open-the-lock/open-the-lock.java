class Solution {
    private List<String> getCombinations(String start){
        List<String> states = new ArrayList<>();
        for(int i=0;i<=3;i++){
            char[] arr = start.toCharArray();
            char original = arr[i];
            arr[i] = original=='9' ? '0' : (char)(original+1);
            states.add(new String(arr));
            arr[i] = original=='0' ? '9' : (char)(original-1);
            states.add(new String(arr));


        }
        return states;

    }
    public int openLock(String[] deadends, String target) {
        HashSet<String> dead = new HashSet<>();
        for(String s: deadends){
            dead.add(s);
        }
        String start ="0000";
        if(start.equals(target))
            return 0;
        Queue<String> q = new LinkedList<>();
        if(dead.contains(start) || dead.contains(target))
            return -1;
        q.add(start);
        Set<String> vis = new HashSet<>();
        vis.add(start);
        int steps=0;
        while(!q.isEmpty()){
            int size = q.size();
            while(size-- >0){
                String curr = q.poll();
                for(String child: getCombinations(curr)){
                    if(child.equals(target))
                        return 1+steps;
                    if(dead.contains(child) || vis.contains(child))
                        continue;
                    q.add(child);
                    vis.add(child);
                }

            }
            steps++;
        }
        return -1;
    }
}