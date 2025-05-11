class Solution {
    private boolean canEat(int t, int[] piles, int h){
        int sum=0;
        for(int n: piles){
            sum+= (Math.ceil((double) n/t));
        }
        return sum<=h;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int end = Arrays.stream(piles).max().getAsInt();
        int start = 0;

        while(start<=end){
            int mid = end+(start-end)/2;
            if(canEat(mid, piles, h)){
                end= mid-1;
            }else{
                start=mid+1;
            }
        }
        return start;

    }
}