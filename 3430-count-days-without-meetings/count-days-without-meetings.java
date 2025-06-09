class Solution {
    public int countDays(int days, int[][] meetings) {
        Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0]));

        int lastEnd = 0, ans=0;
        for(int i=0;i<meetings.length;i++){
            int[] meet = meetings[i];
            if(lastEnd+1<meet[0]){
                ans+=(meet[0] - lastEnd-1);
            }
            lastEnd = Math.max(lastEnd, meet[1]);

        }
        if(lastEnd<days){
            ans+=(days-lastEnd);
        }

        return ans;
    }
}