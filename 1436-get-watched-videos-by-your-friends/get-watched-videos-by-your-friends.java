class Solution {
    public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
        Queue<Integer> q= new LinkedList<>();
        q.add(id);
        int currLev=0;
        boolean[] vis = new boolean[friends.length];
        vis[id]=true;
        
        List<Integer> temp = new ArrayList<>();

        // BFS to find friends at the given level
        while (!q.isEmpty() && currLev < level) {
            int size = q.size();
            currLev++;
            temp = new ArrayList<>();  // ✅ Reset temp AFTER processing a level
            for (int i = 0; i < size; i++) {
                int node = q.poll();
                for (int nei : friends[node]) {
                    if (!vis[nei]) {
                        vis[nei] = true;
                        temp.add(nei);
                        q.add(nei);
                    }
                }
            }
        }

        // Count the frequency of watched videos from the friends at the required level
        Map<String, Integer> freq = new HashMap<>();
        for (int friendId : temp) {  // ✅ Use temp instead of q
            for (String video : watchedVideos.get(friendId)) {
                freq.put(video, freq.getOrDefault(video, 0) + 1);
            }
        }

        // Sort videos based on frequency first, then lexicographically
        List<String> res = new ArrayList<>(freq.keySet());
        res.sort((e1, e2) -> freq.get(e1).equals(freq.get(e2)) ? e1.compareTo(e2) : Integer.compare(freq.get(e1), freq.get(e2)));

        return res;

    }
}