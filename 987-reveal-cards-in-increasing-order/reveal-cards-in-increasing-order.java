class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        int n=deck.length;
        int[] ans = new int[n];
        Deque<Integer> dq = new ArrayDeque<>();
        Arrays.sort(deck);
        for(int i=0;i<n;i++){
            dq.addLast(i);
        }
        int i=0;
        while(!dq.isEmpty()){
            int first = dq.pollFirst();
            ans[first] = deck[i++];
            if(!dq.isEmpty()){
                dq.addLast(dq.pollFirst());
            }
        }
        return ans;
        
    }
}