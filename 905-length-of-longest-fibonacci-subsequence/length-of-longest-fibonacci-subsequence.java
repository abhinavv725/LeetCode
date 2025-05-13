class Solution {
    public int lenLongestFibSubseq(int[] arr) {
        int n=arr.length;
        HashSet<Integer> set = new HashSet<>();
        for(int m: arr){
            set.add(m);
        }
        int ans=0;

        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int prev = arr[i], temp=2;
                int curr= arr[j];
                int nxt = prev+curr;
                while(set.contains(nxt)){
                    temp++;
                    prev=curr;
                    curr=nxt;
                    nxt=prev+curr;
                }
                ans = Math.max(ans, temp==2?0:temp);
            }
        }
        return ans;
    }
}