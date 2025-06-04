class Solution {
    public int lenLongestFibSubseq(int[] arr) {
        int ans=0;
        Set<Integer> set = new HashSet<>();
        for(int i: arr){
            set.add(i);
        }
        int n=arr.length;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
            int prev = arr[i];

                int curr = arr[j] , temp=2, nxt = curr+prev;
                while(set.contains(nxt)){
                    temp++;
                    prev=curr;
                    curr=nxt;
                    nxt = curr+prev;

                }
                ans = Math.max(ans, temp==2?0:temp);

            }
        }

        return ans;
    }
}