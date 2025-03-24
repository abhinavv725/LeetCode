class Solution {
    public int countDays(int days, int[][] meetings) {
        Arrays.sort(meetings, (a,b) -> Integer.compare(a[0],b[0]));

        int res=0;
        int latestEnd=0;
        for(int[] meet: meetings){
            int start=meet[0];
            int end =meet[1];
            if(start> latestEnd+1){
                res+= start-latestEnd-1;
            }
            latestEnd = Math.max(latestEnd, end);
        }
        res+=days-latestEnd;
        return res;
    }
}