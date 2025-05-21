class Solution {
    private boolean canMakeCars(long time, int cars, int[] ranks){
        long count=0;
        for(int rank: ranks){
            count+=(long) Math.sqrt((double)time/rank);
            if(count >= cars) return true;  // early stop
        }
        return count>=cars;
    }
    public long repairCars(int[] ranks, int cars) {
        long low = 0 ;
        // long high = (Arrays.stream(ranks).max().getAsInt()) * cars *cars;
        long high = Long.MAX_VALUE;

        long res=0;
        while(low<=high){
            long mid = low+(high-low)/2;
            if(canMakeCars(mid, cars, ranks)){
                res = mid;
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return res;

    }
}