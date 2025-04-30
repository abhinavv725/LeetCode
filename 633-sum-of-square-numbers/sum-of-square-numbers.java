class Solution {
    public boolean judgeSquareSum(int c) {
        if(c<=2)
            return true;
        int start=0, end = (int) Math.sqrt(c);
        while(start<=end){
            long temp = (long)(start* start) + (long)(end*end);
            if(temp==c)
                return true;
            else if(temp>c){
                end--;
            }else{
                start++ ;
            }
        }
        return false;
        
    }
}