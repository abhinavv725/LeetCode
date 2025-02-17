class Solution {
    Set<String> ans = new HashSet<>();
    int n;
    private void check(String s, String curr, boolean[] vis){
        for(int i=0;i<n;i++){
            if(vis[i])
                continue;
            
            String sequence = curr + s.charAt(i);
            ans.add(sequence);
            vis[i]=true;

            check(s, sequence, vis);
            vis[i]=false;
        }

    }
    public int numTilePossibilities(String tiles) {
        n=tiles.length();
        
        boolean[] vis = new boolean[tiles.length()];
        check(tiles, "" , vis);
        return ans.size();
    }
}