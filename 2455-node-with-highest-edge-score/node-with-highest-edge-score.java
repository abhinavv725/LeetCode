class Solution {
    public int edgeScore(int[] edges) {
        long[] ans = new long [edges.length];
        for(int i=0;i<edges.length;i++){
            ans[edges[i]]+=i;
        }
        long max = Long.MIN_VALUE;
        int node=0;
        for(int i=0;i<edges.length;i++){
            if(ans[i]>max){
                max=ans[i];
                node=i;
            }
        }
        return node;
    }
}