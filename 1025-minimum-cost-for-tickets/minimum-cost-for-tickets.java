class Solution {
    public int mincostTickets(int[] days, int[] cost) {
        int maxday=days[days.length-1];
        boolean[] travel = new boolean[maxday+1];

        for(int day: days){
            travel[day]=true;
        }

        int[] dp = new int[maxday+1];
        int i=0;
        for(int day=1;day<=maxday;day++){
            if(day< days[i]){
                dp[day]=dp[day-1];
                continue;
            }else{
                i++;
                dp[day]=cost[0]+dp[day-1];
                if(day-7>=0){
                    dp[day]=Math.min(dp[day], cost[1]+dp[day-7]);
                }else{
                    dp[day]=Math.min(dp[day], cost[1]);
                }
                if(day-30>=0){
                    dp[day]=Math.min(dp[day], cost[2]+dp[day-30]);
                }else{
                    dp[day]=Math.min(dp[day], cost[2]);
                }
            }
        }


        return dp[maxday];
    }
}